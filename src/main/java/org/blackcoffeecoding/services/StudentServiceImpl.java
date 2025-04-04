package org.blackcoffeecoding.services;

import org.blackcoffeecoding.dto.AddDisciplineDto;
import org.blackcoffeecoding.dto.AddStudentDto;
import org.blackcoffeecoding.dto.ShowDisciplineInfoDto;
import org.blackcoffeecoding.dto.ShowStudentInfoDto;
import org.blackcoffeecoding.models.entities.Discipline;
import org.blackcoffeecoding.models.entities.Student;
import org.blackcoffeecoding.repositories.DisciplineRepository;
import org.blackcoffeecoding.repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@EnableCaching
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper mapper;

    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper mapper) {
        this.studentRepository = studentRepository;
        this.mapper = mapper;
    }

    @CacheEvict(cacheNames = "students", allEntries = true)
    public void addStudent (AddStudentDto addStudentDto) {
        studentRepository.saveAndFlush(mapper.map(addStudentDto, Student.class));
    }

    @Cacheable("students")
    public List<ShowStudentInfoDto> allStudents() {
        return studentRepository.findAll().stream().map(student -> mapper.map(student, ShowStudentInfoDto.class))
                .collect(Collectors.toList());
    }

    @CacheEvict(cacheNames = "students", allEntries = true)
    public void removeStudent(Integer gbNumber) {
        studentRepository.deleteByGbNumber(gbNumber);
    }
}
