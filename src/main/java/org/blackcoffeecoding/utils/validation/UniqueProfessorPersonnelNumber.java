package org.blackcoffeecoding.utils.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueProfessorPersonnelNumberValidator.class)
public @interface UniqueProfessorPersonnelNumber {
    String message() default "Табельный номер занят";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};



}
