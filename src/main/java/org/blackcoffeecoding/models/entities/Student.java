package org.blackcoffeecoding.models.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends BaseEntity{
    private Integer gbNumber;
    private String fullName;
    private String studentGroup;

    private Set<Attendance> attendances;
    public Student (){
        attendances=new HashSet<>();
    }

    @Column(unique = true,nullable = false)
    public Integer getGbNumber() {
        return gbNumber;
    }
    public void setGbNumber(Integer gbNumber) {
        this.gbNumber = gbNumber;
    }

    @Column (nullable = false)
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column (nullable = false)
    public String getStudentGroup() {
        return studentGroup;
    }
    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    @OneToMany(mappedBy = "student", targetEntity = Attendance.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Attendance> getAttendances() {
        return attendances;
    }
    public void setAttendances(Set<Attendance> attendances) {
        this.attendances = attendances;
    }
}
