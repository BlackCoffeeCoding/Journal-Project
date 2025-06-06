package org.blackcoffeecoding.utils.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueDisciplineCodeValidator.class)
public @interface UniqueDisciplineCode {
    String message() default "Дисциплина с таким кодом уже существует";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};



}
