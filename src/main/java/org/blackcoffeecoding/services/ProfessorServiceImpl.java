package org.blackcoffeecoding.services;

import org.blackcoffeecoding.dto.AddProfessorDto;
import org.blackcoffeecoding.dto.ShowProfessorInfoDto;
import org.blackcoffeecoding.models.entities.Professor;
import org.blackcoffeecoding.repositories.ProfessorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@EnableCaching
public class ProfessorServiceImpl implements ProfessorService {
    private final ProfessorRepository professorRepository;
    private final ModelMapper mapper;

    public ProfessorServiceImpl(ProfessorRepository professorRepository, ModelMapper mapper) {
        this.professorRepository = professorRepository;
        this.mapper = mapper;
    }

    @CacheEvict(cacheNames = "professors", allEntries = true)
    public void addProfessor (AddProfessorDto addProfessorDto) {
        professorRepository.saveAndFlush(mapper.map(addProfessorDto, Professor.class));
    }

    @Cacheable("professors")
    public List<ShowProfessorInfoDto> allProfessors() {
        return professorRepository.findAll().stream().map(professor -> mapper.map(professor, ShowProfessorInfoDto.class))
                .collect(Collectors.toList());
    }

    @CacheEvict(cacheNames = "professors", allEntries = true)
    public void removeProfessor(Integer personnelNumber) {
        professorRepository.deleteByPersonnelNumber(personnelNumber);
    }
}
