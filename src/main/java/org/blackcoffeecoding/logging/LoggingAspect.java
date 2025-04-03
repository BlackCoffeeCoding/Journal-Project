package org.blackcoffeecoding.logging;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *) || within(org.blackcoffeecoding.web..*)")
    public void controller() {}

    @Around("controller()")
    public Object logRequestAndResponse(ProceedingJoinPoint joinPoint) throws Throwable {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        logger.info("Request: [method={}, URI={}, params={}]",
                request.getMethod(),
                request.getRequestURI(),
                request.getParameterMap());

        Object result = joinPoint.proceed();
        logger.info("Response: [status={}, body={}]",
                HttpServletResponse.SC_OK,  // или получите реальный статус ответа
                result);

        return result;
    }

    @Pointcut("within(@org.springframework.stereotype.Service *) || within(org.blackcoffeecoding.services..*)")
    public void serviceLayer() {}

    @Around("serviceLayer()")
    public Object logServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();

        logger.info("Service method called: {}, args: {}", methodName, args);

        try {
            Object result = joinPoint.proceed();
            long duration = System.currentTimeMillis() - start;

            logger.info("Service method finished: {}, result: {}, execution time: {} ms", methodName, result, duration);

            return result;
        } catch (Exception e) {
            logger.error("Service method failed: {}, error: {}", methodName, e.getMessage(), e);
            throw e;
        }
    }
}
