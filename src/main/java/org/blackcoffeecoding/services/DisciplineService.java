package org.blackcoffeecoding.services;

import org.blackcoffeecoding.dto.AddDisciplineDto;
import org.blackcoffeecoding.dto.ShowDisciplineInfoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DisciplineService {

    void addDiscipline(AddDisciplineDto addDisciplineDto);

    List<ShowDisciplineInfoDto> allDisciplines();

    void removeDiscipline(Integer code);
}
