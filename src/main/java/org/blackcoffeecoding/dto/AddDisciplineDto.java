package org.blackcoffeecoding.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.blackcoffeecoding.models.entities.Lesson;
import org.blackcoffeecoding.utils.validation.UniqueDisciplineCode;

import java.util.HashSet;
import java.util.Set;

public class AddDisciplineDto {
    @UniqueDisciplineCode
    private Integer code;
    private String name;
    private String department;

    @NotNull(message = "Discipline code must not be null or empty!")
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }

    @NotEmpty(message = "Discipline name must not be null or empty!")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @NotEmpty(message = "Department must not be null or empty!")
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
}
