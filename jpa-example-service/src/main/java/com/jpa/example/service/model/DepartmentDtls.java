package com.jpa.example.service.model;

import javax.persistence.*;

@Entity
@Table(name = "department_dtls")
public class DepartmentDtls {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deptId;
    private String deptName;
    private String address;

}