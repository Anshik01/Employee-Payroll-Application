package com.uc.employeepayroll.model;

import lombok.Getter;
import lombok.Setter;

// using getter setter annotation to access getter and setter for the private attribute
@Getter
@Setter
public class EmployeeModel {

    private Long id;
    private String name;
    private double salary;

}
