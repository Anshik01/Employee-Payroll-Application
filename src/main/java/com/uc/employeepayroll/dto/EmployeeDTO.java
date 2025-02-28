package com.uc.employeepayroll.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

// using getter setter annotation to access getter and setter for the private attribute
@Getter
@Setter
public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "Name is required field.")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name provided is invalid.")
    private String name;

    private double salary;

    private String gender;

    private String startDate;

    private String note;

    private String profilePic;

    private String department;
}
