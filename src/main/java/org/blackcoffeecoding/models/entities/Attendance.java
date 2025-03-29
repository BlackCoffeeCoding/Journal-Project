package org.blackcoffeecoding.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name = "attendances")
public class Attendance extends BaseEntity{
    @ManyToOne
    private Lesson lesson;
    @ManyToOne
    private Student student;

    private Boolean presence;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    public Lesson getLesson() {
        return lesson;
    }
    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    @Column(nullable = false)
    public Boolean getPresence() {
        return presence;
    }
    public void setPresence(Boolean presence) {
        this.presence = presence;
    }
}
