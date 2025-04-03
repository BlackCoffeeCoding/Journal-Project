package org.blackcoffeecoding.services;

import org.blackcoffeecoding.dto.AddProfessorDto;
import org.blackcoffeecoding.dto.ShowProfessorInfoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfessorService {

    void addProfessor(AddProfessorDto addProfessorDto);

    List<ShowProfessorInfoDto> allProfessors();

    void removeProfessor(Integer personnelNumber);
}
