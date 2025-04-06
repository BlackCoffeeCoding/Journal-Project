package org.blackcoffeecoding.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class ShowStudentInfoDto implements Serializable {
    private Integer gbNumber;
    private String fullName;
    private String studentGroup;

    public Integer getGbNumber() {
        return gbNumber;
    }
    public void setGbNumber(Integer gbNumber) {
        this.gbNumber = gbNumber;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStudentGroup() {
        return studentGroup;
    }
    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }
}
