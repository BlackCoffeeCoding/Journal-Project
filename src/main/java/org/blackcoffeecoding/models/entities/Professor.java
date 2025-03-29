package org.blackcoffeecoding.models.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "professors")
public class Professor extends BaseEntity{
    private Integer personnelNumber;
    private String fullName;
    private String birthDate;
    private Integer experience;
    private String department;
    private String jobTitle;
    private String disciplines;

    private Set<Lesson> lessons;
    public Professor () {
        lessons=new HashSet<>();
    }

    @Column (unique = true,nullable = false)
    public Integer getPersonnelNumber() {
        return personnelNumber;
    }
    public void setPersonnelNumber(Integer personnelNumber) {
        this.personnelNumber = personnelNumber;
    }

    @Column (nullable = false)
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column (nullable = false)
    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Column (nullable = false)
    public Integer getExperience() {
        return experience;
    }
    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    @Column (nullable = false)
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    @Column (nullable = false)
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Column (nullable = false)
    public String getDisciplines() {
        return disciplines;
    }
    public void setDisciplines(String disciplines) {
        this.disciplines = disciplines;
    }

    @OneToMany(mappedBy = "professor", targetEntity = Lesson.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Lesson> getLessons() {
        return lessons;
    }
    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }
}
