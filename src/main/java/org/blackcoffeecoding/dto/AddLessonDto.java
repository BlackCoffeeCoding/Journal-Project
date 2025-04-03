package org.blackcoffeecoding.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.blackcoffeecoding.models.entities.Attendance;
import org.blackcoffeecoding.models.entities.Discipline;
import org.blackcoffeecoding.models.entities.Professor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashSet;
import java.util.Set;

public class AddLessonDto {
    private String date;
    private String time;
    private Integer number;
    private String classroom;
    private String studentGroup;
    private Integer disciplineCode;
    private Integer professorPersonnelNumber;

    @NotEmpty(message = "Lesson date must not be null or empty!")
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    @NotEmpty(message = "Lesson time must not be null or empty!")
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    @NotNull(message = "Lesson number must not be null or empty!")
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }

    @NotEmpty(message = "Lesson classroom must not be null or empty!")
    public String getClassroom() {
        return classroom;
    }
    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    @NotEmpty(message = "Student group must not be null or empty!")
    public String getStudentGroup() {
        return studentGroup;
    }
    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    @NotNull(message = "Discipline code must not be null or empty!")
    public Integer getDisciplineCode() {
        return disciplineCode;
    }
    public void setDisciplineCode(Integer disciplineCode) {
        this.disciplineCode = disciplineCode;
    }

    @NotNull(message = "Professor personnel number must not be null or empty!")
    public Integer getProfessorPersonnelNumber() {
        return professorPersonnelNumber;
    }
    public void setProfessorPersonnelNumber(Integer professorPersonnelNumber) {
        this.professorPersonnelNumber = professorPersonnelNumber;
    }
}
