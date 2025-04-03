package org.blackcoffeecoding.services;

import org.blackcoffeecoding.dto.AddStudentDto;
import org.blackcoffeecoding.dto.ShowStudentInfoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    void addStudent(AddStudentDto addStudentDto);

    List<ShowStudentInfoDto> allStudents();

    void removeStudent(Integer gbNumber);
}
