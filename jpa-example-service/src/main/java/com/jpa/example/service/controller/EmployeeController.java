package com.jpa.example.service.controller;

import com.jpa.example.service.model.EmployeeDetails;
import com.jpa.example.service.repository.EmployeeDetailsJpaRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeController {

    //employee repos
    private final EmployeeDetailsJpaRepo employeeDetailsJpaRepo;

    @GetMapping
    public List<EmployeeDetails> getAllEmployees(){
        return employeeDetailsJpaRepo.findAll();
    }

    @GetMapping("/page")
    public Page<EmployeeDetails> getPageWiseEmployees1(@RequestParam Integer page, @RequestParam Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return employeeDetailsJpaRepo.findAll(pageable);
    }

    @PostMapping
    public EmployeeDetails saveEmployeeDetails(@RequestBody EmployeeDetails employeeDetails){
        employeeDetails.setEmpRegId("EMP-"+ new Random().nextInt(999999));
        EmployeeDetails savedEmp = employeeDetailsJpaRepo.save(employeeDetails);
        return savedEmp;
    }

    @GetMapping("/pageWithSort")
    public Page<EmployeeDetails> getPageWiseWithSortingEmployeeDetails(@RequestParam Integer page, @RequestParam Integer size, @RequestParam boolean asc, @RequestParam String... properties){
        //Sort sort = Sort.by(asc? Sort.Direction.ASC: Sort.Direction.DESC, properties);
        //Pageable pageable = PageRequest.of(page, size, sort);
        //above two lines and below one line same
        Pageable pageable = PageRequest.of(page, size, asc? Sort.Direction.ASC: Sort.Direction.DESC, properties);
        return employeeDetailsJpaRepo.findAll(pageable);
    }


}
