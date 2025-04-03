package org.blackcoffeecoding.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ShowLessonInfoDto {
    private String date;
    private String time;
    private Integer number;
    private String classroom;
    private String studentGroup;
    private Integer disciplineCode;
    private Integer professorPersonnelNumber;

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getClassroom() {
        return classroom;
    }
    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getStudentGroup() {
        return studentGroup;
    }
    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    public Integer getDisciplineCode() {
        return disciplineCode;
    }
    public void setDisciplineCode(Integer disciplineCode) {
        this.disciplineCode = disciplineCode;
    }

    public Integer getProfessorPersonnelNumber() {
        return professorPersonnelNumber;
    }
    public void setProfessorPersonnelNumber(Integer professorPersonnelNumber) {
        this.professorPersonnelNumber = professorPersonnelNumber;
    }
}
