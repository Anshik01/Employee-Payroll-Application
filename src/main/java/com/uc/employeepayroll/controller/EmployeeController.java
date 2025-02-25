package com.uc.employeepayroll.controller;


import com.uc.employeepayroll.dto.EmployeeDTO;
import com.uc.employeepayroll.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<String>> getAllEmployee(){
        // print all employees name
        return new ResponseEntity<>(employeeService.getAllEmployee() , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getEmployee(@PathVariable Long id){
        // searching in list if the id is present in tha list
        String name = employeeService.getEmployee(id);

        // return name of the employee if exist in list
        if(name != null){
            return new ResponseEntity<>("Searched for employee : " + name, HttpStatus.OK);
        }

        return new ResponseEntity<>("Searched employee is not present!!", HttpStatus.OK);
    }

    // adding new employee
    @PostMapping("/post")
    public ResponseEntity<String> postEmployee(@RequestBody EmployeeDTO employee){
        // print name of added employee
        return new ResponseEntity<>("Employee created : " + employeeService.addEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<String> putEmployee(@PathVariable Long id,
                                              @RequestBody EmployeeDTO employee){
        // update employee given by data given by user
        String name = employeeService.updateEmployee(id, employee);

        // print name of employee record updated
        if(name != null){
            return new ResponseEntity<>("Updated employee: " + name, HttpStatus.OK);
        }

        // if record doesn't exist then return this message
        return new ResponseEntity<>("Employee id does not exist!!", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        // deleting the employee
        String name = employeeService.deleteEmployee(id);

        // print name of employee record deleted
        if(name != null){
            return new ResponseEntity<>("Deleted employee : " + name, HttpStatus.OK);
        }

        // if record doesn't exist then return this message
        return new ResponseEntity<>("Data of the searched employee doesn't exist.", HttpStatus.OK);
    }
}
