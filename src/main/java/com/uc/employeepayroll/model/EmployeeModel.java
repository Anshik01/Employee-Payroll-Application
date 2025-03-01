package com.uc.employeepayroll.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

// using getter setter annotation to access getter and setter for the private attribute
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "Employee")
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    private String department;

}
