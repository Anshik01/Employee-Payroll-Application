package com.uc.employeepayroll.dto;

public class EmployeeDTO {
    private String name;
    private double salary;

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
