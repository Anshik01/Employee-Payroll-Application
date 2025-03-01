package com.uc.employeepayroll.service;

import com.uc.employeepayroll.dto.EmployeeDTO;
import com.uc.employeepayroll.exception.EmployeeNotFoundException;
import com.uc.employeepayroll.model.EmployeeModel;
import com.uc.employeepayroll.repository.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    private ModelMapper modelMapper = new ModelMapper();

    // using list to store data of all employee
    List<EmployeeDTO> store = new ArrayList<>();

    public List<String> getAllEmployee(){
        List<String> nameOfEmployee = new ArrayList<>();

        for(EmployeeDTO emp : store){
            nameOfEmployee.add(emp.getName());
        }

        // returning name of all employees present in data
        log.info("Return list of all employee");
        return nameOfEmployee;
    }

    public String getEmployee(Long id) throws EmployeeNotFoundException {
        for(EmployeeDTO emp : store){
            if (Objects.equals(emp.getId(), id)){
                log.info("Searched employee has been returned");
                return emp.getName();
            }
        }
        // throw exception if employee is not found
        log.error("Can't find employee");
        throw new EmployeeNotFoundException("Employee does not exist");
    }

    public String addEmployee(EmployeeDTO employee){
        EmployeeModel employeeModel = modelMapper.map(employee, EmployeeModel.class);
        employeeRepo.save(employeeModel);

        log.info("Given employee has been added to the database");
        return employee.getName();
    }

    public String updateEmployee(Long id, EmployeeDTO employee) throws EmployeeNotFoundException {

        for(EmployeeDTO emp : store){
            if(Objects.equals(emp.getId(), id)){
                emp.setName(employee.getName());
                emp.setSalary(employee.getSalary());
                log.info("Updated the employee");
                return employee.getName();
            }
        }
        // throw exception if employee is not found
        log.error("Employee can't found");
        throw new EmployeeNotFoundException("Employee does not exist");
    }

    public String deleteEmployee(Long id) throws EmployeeNotFoundException {
        for(EmployeeDTO emp : store){
            if (Objects.equals(emp.getId(), id)){
                store.remove(emp);
                log.info("Employee has been deleted");
                return emp.getName();
            }
        }
        // throw exception if employee is not found
        log.error("Employee can't be found");
        throw new EmployeeNotFoundException("Employee does not exist");
    }
}
