package org.blackcoffeecoding.services;

import org.blackcoffeecoding.dto.AddDisciplineDto;
import org.blackcoffeecoding.dto.ShowDisciplineInfoDto;
import org.blackcoffeecoding.models.entities.Discipline;
import org.blackcoffeecoding.repositories.DisciplineRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DisciplineServiceImpl implements DisciplineService {
    private final DisciplineRepository disciplineRepository;
    private final ModelMapper mapper;

    public DisciplineServiceImpl(DisciplineRepository disciplineRepository, ModelMapper mapper) {
        this.disciplineRepository = disciplineRepository;
        this.mapper = mapper;
    }

    public void addDiscipline (AddDisciplineDto addDisciplineDto) {
        disciplineRepository.saveAndFlush(mapper.map(addDisciplineDto, Discipline.class));
    }

    public List<ShowDisciplineInfoDto> allDisciplines() {
        return disciplineRepository.findAll().stream().map(discipline -> mapper.map(discipline, ShowDisciplineInfoDto.class))
                .collect(Collectors.toList());
    }

    public void removeDiscipline(Integer code) {
        disciplineRepository.deleteByCode(code);
    }
}
