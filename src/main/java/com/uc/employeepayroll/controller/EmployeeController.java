package com.uc.employeepayroll.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @GetMapping("/all")
    public ResponseEntity<String> getAllEmployee(){
        return new ResponseEntity<>("All employees are : " , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getEmployee(@PathVariable Long id){
        return new ResponseEntity<>("Get employee ID: " + id, HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<String> postEmployee(@RequestBody Object employee){
        return new ResponseEntity<>("Employee created : ", HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<String> putEmployee(@PathVariable Long id){
        return new ResponseEntity<>("Updated employee: " + id, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        return new ResponseEntity<>("Deleted employee : " + id, HttpStatus.OK);
    }
}
