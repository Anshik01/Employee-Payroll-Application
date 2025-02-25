package com.uc.employeepayroll.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/employee")
    public ResponseEntity<String> getEmployee(@RequestParam(required = false, defaultValue = "Guest") String name){
        return new ResponseEntity<>("Welcome " + name, HttpStatus.OK);
    }

}
