package org.blackcoffeecoding.dto;

import java.io.Serializable;

public class ShowLessonInfoDto implements Serializable {
    private String id;
    private String date;
    private String time;
    private Integer number;
    private String classroom;
    private String studentGroup;
    private String disciplineName;
    private String professorFullName;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

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

    public String getDisciplineName() {
        return disciplineName;
    }
    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public String getProfessorFullName() {
        return professorFullName;
    }
    public void setProfessorFullName(String professorFullName) {
        this.professorFullName = professorFullName;
    }
}
