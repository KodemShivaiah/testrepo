package com.jpa.example.service.repository;

import com.jpa.example.service.model.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDetailsJpaRepo extends JpaRepository<EmployeeDetails, Long> {

}
