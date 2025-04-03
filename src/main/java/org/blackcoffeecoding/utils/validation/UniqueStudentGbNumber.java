package org.blackcoffeecoding.utils.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueStudentGbNumberValidator.class)
public @interface UniqueStudentGbNumber {
    String message() default "Студент с такой зачётной книжкой уже существует";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};



}
