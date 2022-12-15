package com.validation.example.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
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
    @Size(min = 2, max = 10, message = "user name should have at least 2 characters.") //name should have at least 2 characters
    private String name;
    @NotEmpty //email should not be null or empty
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "Invalid email id") //email should be a valid format
    private String email;
    @NotEmpty // password should not be null or empty
    @Size(min = 8, message = "password should have at least 8 characters.")
    private String password;

    @Pattern(regexp = "[+]+[0-9]+[.-]+[0-9]", message = "Please enter valid contact no.")
    private String contactNo;

}
