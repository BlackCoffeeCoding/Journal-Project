package org.blackcoffeecoding.models.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "disciplines")
public class Discipline extends BaseEntity{
    private Integer code;
    private String name;
    private String department;

    private Set <Lesson> lessons;
    public Discipline (){
        lessons=new HashSet<>();
    }

    @Column (unique = true,nullable = false)
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    @OneToMany(mappedBy = "discipline", targetEntity = Lesson.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Lesson> getLessons() {
        return lessons;
    }
    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }
}
