package org.blackcoffeecoding.services;

import org.blackcoffeecoding.dto.AddProfessorDto;
import org.blackcoffeecoding.dto.ShowProfessorInfoDto;
import org.blackcoffeecoding.models.entities.Professor;
import org.blackcoffeecoding.repositories.ProfessorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    private final ProfessorRepository professorRepository;
    private final ModelMapper mapper;

    public ProfessorServiceImpl(ProfessorRepository professorRepository, ModelMapper mapper) {
        this.professorRepository = professorRepository;
        this.mapper = mapper;
    }

    public void addProfessor (AddProfessorDto addProfessorDto) {
        professorRepository.saveAndFlush(mapper.map(addProfessorDto, Professor.class));
    }

    public List<ShowProfessorInfoDto> allProfessors() {
        return professorRepository.findAll().stream().map(professor -> mapper.map(professor, ShowProfessorInfoDto.class))
                .collect(Collectors.toList());
    }

    public void removeProfessor(Integer personnelNumber) {
        professorRepository.deleteByPersonnelNumber(personnelNumber);
    }
}
