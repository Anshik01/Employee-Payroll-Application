package com.uc.employeepayroll.controller;


import com.uc.employeepayroll.dto.EmployeeDTO;
import com.uc.employeepayroll.exception.EmployeeNotFoundException;
import com.uc.employeepayroll.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@Validated
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee(){
        // print all employees name
        log.info("All employees are printed");
        return new ResponseEntity<>(employeeService.getAllEmployee() , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Long id) throws EmployeeNotFoundException {
        // searching in list if the id is present in tha list
        EmployeeDTO name = employeeService.getEmployee(id);

        // return name of the employee if exist in list

        log.info("Employee with name {} is printed", name);
        return new ResponseEntity<>(name, HttpStatus.OK);

    }

    // adding new employee
    @PostMapping("/post")
    public ResponseEntity<String> postEmployee(@Valid @RequestBody EmployeeDTO employee){
        // print name of added employee
        log.info("{} has been added to the list", employee.getName());
        return new ResponseEntity<>("Employee created : " + employeeService.addEmployee(employee), HttpStatus.CREATED);
    }



    @PutMapping("/put/{id}")
    public ResponseEntity<EmployeeDTO> putEmployee(@PathVariable Long id,
                                              @Valid @RequestBody EmployeeDTO employee) throws EmployeeNotFoundException {

        // update employee given by data given by user
        EmployeeDTO name = employeeService.updateEmployee(id, employee);

        // print name of employee record updated

        log.info("Employee info has been updated.");
        return new ResponseEntity<>(name, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) throws EmployeeNotFoundException {
        // deleting the employee
        boolean isDeleted = employeeService.deleteEmployee(id);

        if(isDeleted){
            log.info("Employee data has been deleted.");
            return new ResponseEntity<>("Employee has been deleted.", HttpStatus.OK);
        }
        else{
            log.info("Employee data has not been deleted.");
            return new ResponseEntity<>("Employee has not been delted.", HttpStatus.BAD_REQUEST);
        }
    }
}
