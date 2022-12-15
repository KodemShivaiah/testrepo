package com.validation.example.controller;

import com.validation.example.dto.EmployeeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployeeDetails(@Valid @RequestBody EmployeeDto employeeDto){
        System.out.println(employeeDto.toString());
        return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
    }

}
