package org.blackcoffeecoding.services;

import org.blackcoffeecoding.dto.AddLessonDto;
import org.blackcoffeecoding.dto.ShowLessonInfoDto;
import org.blackcoffeecoding.models.entities.Lesson;
import org.blackcoffeecoding.repositories.DisciplineRepository;
import org.blackcoffeecoding.repositories.LessonRepository;
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

    @CacheEvict(cacheNames = "lessons", allEntries = true)
    public void addLesson(AddLessonDto addLessonDto) {
        Lesson lesson = mapper.map(addLessonDto, Lesson.class);
        lesson.setDiscipline(disciplineRepository.findByCode(addLessonDto.getDisciplineCode()).orElse(null));
        lesson.setProfessor(professorRepository.findByPersonnelNumber(addLessonDto.getProfessorPersonnelNumber()).orElse(null));
        lessonRepository.saveAndFlush(lesson);
    }

    @Cacheable("lessons")
    public List<ShowLessonInfoDto> allLessons() {
        return lessonRepository.findAll().stream().map(lesson -> mapper.map(lesson, ShowLessonInfoDto.class))
                .collect(Collectors.toList());
    }

    @CacheEvict(cacheNames = "lessons", allEntries = true)
    public void removeLesson(String id) {
        lessonRepository.deleteById(id);
    }
}
