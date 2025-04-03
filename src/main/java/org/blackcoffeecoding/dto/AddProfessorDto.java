package org.blackcoffeecoding.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.blackcoffeecoding.models.entities.Lesson;

import java.util.HashSet;
import java.util.Set;

public class AddProfessorDto {
    private Integer personnelNumber;
    private String fullName;
    private String birthDate;
    private Integer experience;
    private String department;
    private String jobTitle;
    private String disciplines;

    @NotNull(message = "Personnel number must not be null or empty!")
    public Integer getPersonnelNumber() {
        return personnelNumber;
    }
    public void setPersonnelNumber(Integer personnelNumber) {
        this.personnelNumber = personnelNumber;
    }

    @NotEmpty(message = "Professor full name must not be null or empty!")
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @NotEmpty(message = "Professor birth date must not be null or empty!")
    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @NotNull(message = "Experience cannot be null or empty!")
    @Max(value = 70, message = "Experience must be 70 or less years! More than 70 years experience is impossible!")
    public Integer getExperience() {
        return experience;
    }
    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    @NotEmpty(message = "Department must not be null or empty!")
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    @NotEmpty(message = "Job title must not be null or empty!")
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @NotEmpty(message = "Professor must teach at least one discipline!")
    public String getDisciplines() {
        return disciplines;
    }
    public void setDisciplines(String disciplines) {
        this.disciplines = disciplines;
    }
}
