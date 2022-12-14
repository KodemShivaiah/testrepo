package com.jpa.example.service.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empId;
    private String empRegId;
    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;
    private Date dateOfBirth;
    private String temporyAddress;
    private String permenentAddress;

}
