package org.blackcoffeecoding.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AddStudentDto {
    private Integer gbNumber;
    private String fullName;
    private String studentGroup;

    @NotNull(message = "Grade book number must not be null or empty!")
    public Integer getGbNumber() {
        return gbNumber;
    }
    public void setGbNumber(Integer gbNumber) {
        this.gbNumber = gbNumber;
    }

    @NotEmpty(message = "Student full name must not be null or empty!")
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @NotEmpty(message = "Student group must not be null or empty!")
    @Size(min = 7, max = 8, message = "Student group must be like AAA-000 or AAAa-000!")
    public String getStudentGroup() {
        return studentGroup;
    }
    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }
}
