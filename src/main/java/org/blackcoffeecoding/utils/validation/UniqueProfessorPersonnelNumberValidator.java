package org.blackcoffeecoding.utils.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.blackcoffeecoding.repositories.ProfessorRepository;

public class UniqueProfessorPersonnelNumberValidator implements ConstraintValidator<UniqueProfessorPersonnelNumber, Integer> {
    private final ProfessorRepository professorRepository;
    public UniqueProfessorPersonnelNumberValidator(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public boolean isValid(Integer s, ConstraintValidatorContext constraintValidatorContext) {
        return professorRepository.findByPersonnelNumber(s).isEmpty();
    }
}
