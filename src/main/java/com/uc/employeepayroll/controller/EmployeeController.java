package com.uc.employeepayroll.controller;


import com.uc.employeepayroll.dto.EmployeeDTO;
import com.uc.employeepayroll.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<String>> getAllEmployee(){
        // print all employees name
        log.info("All employees are printed");
        return new ResponseEntity<>(employeeService.getAllEmployee() , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getEmployee(@PathVariable Long id){
        // searching in list if the id is present in tha list
        String name = employeeService.getEmployee(id);

        // return name of the employee if exist in list
        if(name != null){
            log.info("Employee with name {} is printed", name);
            return new ResponseEntity<>("Searched for employee : " + name, HttpStatus.OK);
        }

        log.error("Employee doesn't exist");
        return new ResponseEntity<>("Searched employee is not present!!", HttpStatus.NOT_FOUND);
    }

    // adding new employee
    @PostMapping("/post")
    public ResponseEntity<String> postEmployee(@RequestBody EmployeeDTO employee){
        // print name of added employee
        log.info("{} has been added to the list", employee.getName());
        return new ResponseEntity<>("Employee created : " + employeeService.addEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<String> putEmployee(@PathVariable Long id,
                                              @RequestBody EmployeeDTO employee){
        // update employee given by data given by user
        String name = employeeService.updateEmployee(id, employee);

        // print name of employee record updated
        if(name != null){
            log.info("Employee info has been updated.");
            return new ResponseEntity<>("Updated employee: " + name, HttpStatus.OK);
        }

        // if record doesn't exist then return this message
        log.error("Employee doesn't exist hence can't edit");
        return new ResponseEntity<>("Employee id does not exist!!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        // deleting the employee
        String name = employeeService.deleteEmployee(id);

        // print name of employee record deleted
        if(name != null){
            log.info("Employee data has been deleted.");
            return new ResponseEntity<>("Deleted employee : " + name, HttpStatus.OK);
        }

        // if record doesn't exist then return this message
        log.error("Employee doesn't exist hence can't delete");
        return new ResponseEntity<>("Data of the searched employee doesn't exist.", HttpStatus.NOT_FOUND);
    }
}
