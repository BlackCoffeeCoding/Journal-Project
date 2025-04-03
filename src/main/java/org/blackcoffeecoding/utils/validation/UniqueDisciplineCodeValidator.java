package org.blackcoffeecoding.utils.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.blackcoffeecoding.repositories.DisciplineRepository;

public class UniqueDisciplineCodeValidator implements ConstraintValidator<UniqueDisciplineCode, Integer> {
    private final DisciplineRepository disciplineRepository;
    public UniqueDisciplineCodeValidator(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    @Override
    public boolean isValid(Integer s, ConstraintValidatorContext constraintValidatorContext) {
        return disciplineRepository.findByCode(s).isEmpty();
    }
}
