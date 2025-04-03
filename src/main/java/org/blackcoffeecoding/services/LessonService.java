package org.blackcoffeecoding.services;

import org.blackcoffeecoding.dto.AddLessonDto;
import org.blackcoffeecoding.dto.AddStudentDto;
import org.blackcoffeecoding.dto.ShowLessonInfoDto;
import org.blackcoffeecoding.dto.ShowStudentInfoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LessonService {

    void addLesson(AddLessonDto addLessonDto);

    List<ShowLessonInfoDto> allLessons();

    void removeLesson(String id);
}
