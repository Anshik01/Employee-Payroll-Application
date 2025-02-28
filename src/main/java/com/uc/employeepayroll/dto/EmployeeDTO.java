package com.uc.employeepayroll.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

// using getter setter annotation to access getter and setter for the private attribute
@Getter
@Setter
public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "Name is required field.")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name provided is invalid.")
    private String name;

    @Min(value = 500,message = "Min wage should not be less then 500")
    private double salary;

    @NotBlank
    @Pattern(regexp = "Male|Female")
    private String gender;

    @JsonFormat(pattern="dd MMM yyyy")
    private LocalDate startDate;

    @NotBlank
    private String note;

    @NotBlank
    private String profilePic;

    @NotBlank
    private String department;
}
