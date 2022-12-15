package com.validation.example.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDto {
    private Long id;
    @NotEmpty // name should not be null or empty
    @Size(min = 2, message = "user name should have at least 2 characters.") //name should have at least 2 characters
    private String name;
    @NotEmpty //email should not be null or empty
    @Email //email should be a valid format
    private String email;
    @NotEmpty // password should not be null or empty
    @Size(min = 8, message = "password should have at least 8 characters.")
    private String password;

}
