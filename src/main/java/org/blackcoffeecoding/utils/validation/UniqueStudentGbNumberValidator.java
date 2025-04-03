package org.blackcoffeecoding.utils.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.blackcoffeecoding.repositories.StudentRepository;

public class UniqueStudentGbNumberValidator implements ConstraintValidator<UniqueStudentGbNumber, Integer> {
    private final StudentRepository studentRepository;
    public UniqueStudentGbNumberValidator(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public boolean isValid(Integer s, ConstraintValidatorContext constraintValidatorContext) {
        return studentRepository.findByGbNumber(s).isEmpty();
    }
}
