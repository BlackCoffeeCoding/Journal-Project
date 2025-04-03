package org.blackcoffeecoding.services;

import org.blackcoffeecoding.dto.AddLessonDto;
import org.blackcoffeecoding.dto.ShowLessonInfoDto;
import org.blackcoffeecoding.models.entities.Lesson;
import org.blackcoffeecoding.repositories.DisciplineRepository;
import org.blackcoffeecoding.repositories.LessonRepository;
import org.blackcoffeecoding.repositories.ProfessorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    private final ProfessorRepository professorRepository;
    private final DisciplineRepository disciplineRepository;
    private final ModelMapper mapper;

    public LessonServiceImpl(LessonRepository lessonRepository, ProfessorRepository professorRepository,DisciplineRepository disciplineRepository, ModelMapper mapper) {
        this.lessonRepository = lessonRepository;
        this.professorRepository = professorRepository;
        this.disciplineRepository = disciplineRepository;
        this.mapper = mapper;
    }

    public void addLesson(AddLessonDto addLessonDto) {
        Lesson lesson = mapper.map(addLessonDto, Lesson.class);
        lesson.setProfessor(professorRepository.findByPersonnelNumber(addLessonDto.getProfessorPersonnelNumber()).orElse(null));
        lesson.setDiscipline(disciplineRepository.findByCode(addLessonDto.getDisciplineCode()).orElse(null));
        lessonRepository.saveAndFlush(lesson);
    }

    public List<ShowLessonInfoDto> allLessons() {
        return lessonRepository.findAll().stream().map(lesson -> mapper.map(lesson, ShowLessonInfoDto.class))
                .collect(Collectors.toList());
    }

    public void removeLesson(String id) {
        lessonRepository.deleteById(id);
    }
}
