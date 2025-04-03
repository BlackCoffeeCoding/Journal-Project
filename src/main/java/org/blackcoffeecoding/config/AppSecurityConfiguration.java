package org.blackcoffeecoding.config;

import org.blackcoffeecoding.models.enums.UserRoles;
import org.blackcoffeecoding.repositories.UserRepository;
import org.blackcoffeecoding.services.AppUserDetailsServiceImpl;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.DelegatingSecurityContextRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

@Configuration
public class AppSecurityConfiguration {
    private UserRepository userRepository;

    public AppSecurityConfiguration(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, SecurityContextRepository securityContextRepository) throws Exception {
        http
                .authorizeHttpRequests(
                        authorizeHttpRequests ->
                                authorizeHttpRequests.
                                        requestMatchers("/actuator/prometheus", "/actuator/**").permitAll().
                                        requestMatchers("/static/**", "/css/**", "/js/**", "/pic/**", "/webjars/**").permitAll().
                                        requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll().
                                        requestMatchers("/", "/users/login", "/users/register", "/users/login-error").permitAll().
                                        requestMatchers("/lessons/all", "/professors/all", "/disciplines/all", "/students/all").permitAll().
                                        requestMatchers("/users/profile").authenticated().
                                        requestMatchers("/lessons/add","/lessons/lesson-delete/").hasAnyRole(UserRoles.MODERATOR.name(), UserRoles.ADMIN.name()).
                                        requestMatchers("/professors/add", "/professors/professor-delete/", "/disciplines/add","/disciplines/discipline-delete/", "/students/add", "/students/student-delete/").hasRole(UserRoles.ADMIN.name()).
                                        anyRequest().authenticated()
                )
                .formLogin(
                        (formLogin) ->
                                formLogin.
                                        loginPage("/users/login").
                                        usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY).
                                        passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY).
                                        defaultSuccessUrl("/").
                                        failureForwardUrl("/users/login-error")
                )
                .logout((logout) ->
                        logout.logoutUrl("/users/logout").
                                logoutSuccessUrl("/").
                                invalidateHttpSession(true)
                ).securityContext(
                        securityContext -> securityContext.
                                securityContextRepository(securityContextRepository)
                );
        return http.build();
    }

    @Bean
    public SecurityContextRepository securityContextRepository() {
        return new DelegatingSecurityContextRepository(
                new RequestAttributeSecurityContextRepository(),
                new HttpSessionSecurityContextRepository()
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new AppUserDetailsServiceImpl(userRepository);
    }
}
