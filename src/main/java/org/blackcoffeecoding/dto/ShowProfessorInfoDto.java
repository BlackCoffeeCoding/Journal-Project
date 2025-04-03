package org.blackcoffeecoding.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ShowProfessorInfoDto {
    private Integer personnelNumber;
    private String fullName;
    private String birthDate;
    private Integer experience;
    private String department;
    private String jobTitle;
    private String disciplines;

    public Integer getPersonnelNumber() {
        return personnelNumber;
    }
    public void setPersonnelNumber(Integer personnelNumber) {
        this.personnelNumber = personnelNumber;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getExperience() {
        return experience;
    }
    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDisciplines() {
        return disciplines;
    }
    public void setDisciplines(String disciplines) {
        this.disciplines = disciplines;
    }
}
