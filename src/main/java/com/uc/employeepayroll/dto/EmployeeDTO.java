package com.uc.employeepayroll.dto;

import lombok.Getter;
import lombok.Setter;

// using getter setter annotation to access getter and setter for the private attribute
@Getter
@Setter
public class EmployeeDTO {

    private Long id;
    private String name;
    private double salary;

}
