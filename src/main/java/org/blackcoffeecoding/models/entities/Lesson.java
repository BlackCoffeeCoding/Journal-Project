package org.blackcoffeecoding.models.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lessons")
public class Lesson extends BaseEntity{
    private String date;
    private String time;
    private Integer number;
    private String classroom;
    private String studentGroup;

    @ManyToOne
    private Discipline discipline;
    @ManyToOne
    private Professor professor;

    private Set<Attendance> attendances;
    public Lesson (){
        attendances=new HashSet<>();
    }

    @Column(nullable = false)
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    @Column (nullable = false)
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    @Column (nullable = false)
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }

    @Column (nullable = false)
    public String getClassroom() {
        return classroom;
    }
    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    @Column (nullable = false)
    public String getStudentGroup() {
        return studentGroup;
    }
    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    public Discipline getDiscipline() {
        return discipline;
    }
    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    public Professor getProfessor() {
        return professor;
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @OneToMany(mappedBy = "lesson", targetEntity = Attendance.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Attendance> getAttendances() {
        return attendances;
    }
    public void setAttendances(Set<Attendance> attendances) {
        this.attendances = attendances;
    }
}
