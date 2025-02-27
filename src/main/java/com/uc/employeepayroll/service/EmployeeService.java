package com.uc.employeepayroll.service;

import com.uc.employeepayroll.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {

    // using list to store data of all employee
    List<EmployeeDTO> store = new ArrayList<>();

    public List<String> getAllEmployee(){
        List<String> nameOfEmployee = new ArrayList<>();

        for(EmployeeDTO emp : store){
            nameOfEmployee.add(emp.getName());
        }

        // returning name of all employees present in data
        return nameOfEmployee;
    }

    public String getEmployee(Long id){
        for(EmployeeDTO emp : store){
            if (Objects.equals(emp.getId(), id)){
                return emp.getName();
            }
        }
        return null;
    }

    public String addEmployee(EmployeeDTO employee){

        store.add(employee);

        return employee.getName();
    }

    public String updateEmployee(Long id, EmployeeDTO employee){

        for(EmployeeDTO emp : store){
            if(Objects.equals(emp.getId(), id)){
                emp.setName(employee.getName());
                emp.setSalary(employee.getSalary());
                return employee.getName();
            }
        }

        return null;
    }

    public String deleteEmployee(Long id){
        for(EmployeeDTO emp : store){
            if (Objects.equals(emp.getId(), id)){
                store.remove(emp);
                return emp.getName();
            }
        }
        // return null if employee is not found
        return null;
    }
}
