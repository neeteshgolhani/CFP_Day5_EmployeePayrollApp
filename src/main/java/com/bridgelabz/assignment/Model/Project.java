package com.bridgelabz.assignment.Model;

import com.bridgelabz.assignment.DTO.ProjectDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Entity
@Table (name = "Assignment_Details")
public @Data class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean completed;

    public Project(ProjectDTO projectDTO) {

        this.updateProject(projectDTO);
    }

    public Project() {
    }

    public void updateProject(ProjectDTO projectDTO) {
        this.title = projectDTO.title;
        this.description = projectDTO.description;
        this.dueDate = projectDTO.dueDate;
    }
}
