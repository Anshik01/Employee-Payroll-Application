package com.uc.employeepayroll.controller;


import com.uc.employeepayroll.dto.EmployeeDTO;
import com.uc.employeepayroll.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<String> getAllEmployee(){
        return new ResponseEntity<>("All employees are : " , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getEmployee(@PathVariable Long id){
        return new ResponseEntity<>("Get employee ID: " + id, HttpStatus.OK);
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
        return new ResponseEntity<>("Updated employee: " + employeeService.updateEmployee(id, employee), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        return new ResponseEntity<>("Deleted employee : " + id, HttpStatus.OK);
    }
}
