package com.uc.employeepayroll.service;

import com.uc.employeepayroll.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    public String addEmployee(EmployeeDTO employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setName(employee.getName());
        employeeDTO.setSalary(employee.getSalary());

        return employee.getName();
    }

    public String updateEmployee(Long id, EmployeeDTO employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setName(employee.getName());
        employeeDTO.setSalary(employee.getSalary());

        return employee.getName();
    }
}
