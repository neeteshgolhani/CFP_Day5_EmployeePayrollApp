package com.bridgelabz.assignment.DTO;

import jakarta.validation.constraints.*;
import org.springframework.validation.annotation.Validated;
import java.lang.Boolean;
import java.time.LocalDate;
@Validated
public class ProjectDTO {
    @Pattern(regexp = "^[A-Z].{2,}$", message = "Title should start with a capital letter and have a minimum of three characters")
    @NotEmpty(message = "the title cant be null")

    public String title;
    @Size(max = 50, message = "Description should be less than 50 characters")
    @NotEmpty
    public String description;
    @FutureOrPresent(message = "The 'dueDate' must be a future or present date.")
    public LocalDate dueDate;

}
