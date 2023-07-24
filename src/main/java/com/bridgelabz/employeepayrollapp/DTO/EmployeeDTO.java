package com.bridgelabz.employeepayrollapp.DTO;

import jakarta.validation.constraints.*;
import org.springframework.validation.annotation.Validated;
import java.time.LocalDate;
import java.util.List;
@Validated
public class EmployeeDTO {

    @NotBlank(message = "First name is required")
    @Pattern(regexp = "^[A-Z][a-z]*", message = "First name should start with a capital letter")

    public String fName;

    @NotBlank(message = "Last name is required")
    @Pattern(regexp = "^[A-Z][a-z]*", message = "First name should start with a capital letter")

    public String lName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    public String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\d{3}-\\d{3}-\\d{4}$", message = "Invalid phone number format. Use ###-###-####")

    public String phoneNumber;

    @NotBlank(message = "Address is required")
    public String address;

    @NotNull(message = "Salary is required")
    public double salary;

    @NotBlank(message = "Gender is required")
    public String gender;

    @NotNull(message = "Start date is required")
    public LocalDate startDate;

    @NotNull(message = "Department list is required")
    @Size(max = 50, message = "Notes can have a maximum of 50 characters")

    public List<String> department;

    public String notes;
    public String profilePic;

}
