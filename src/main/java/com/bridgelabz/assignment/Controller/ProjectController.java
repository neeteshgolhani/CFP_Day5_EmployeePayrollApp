package com.bridgelabz.assignment.Controller;

import com.bridgelabz.assignment.DTO.ProjectDTO;
import com.bridgelabz.assignment.DTO.ProjectResponseDTO;
import com.bridgelabz.assignment.Repo.ProjectRepo;
import com.bridgelabz.assignment.Service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class ProjectController {
    @Autowired
    private ProjectRepo projectRepo;
    @Autowired
    private ProjectService projectService;
    @PostMapping("/add")
    public ResponseEntity<ProjectResponseDTO> addProject(@Valid @RequestBody ProjectDTO projectDTO) {
        ProjectResponseDTO projectResponseDTO = new ProjectResponseDTO( "Project data added successfully", projectService.addProject(projectDTO));
        return  new ResponseEntity<>(projectResponseDTO, HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<ProjectResponseDTO> getAllProject() {
            ProjectResponseDTO projectResponseDTO = projectService.getAllProject();
            return new ResponseEntity<ProjectResponseDTO>(projectResponseDTO,HttpStatus.OK);
    }
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<ProjectResponseDTO> getById(@PathVariable long id) {
        ProjectResponseDTO projectResponseDTO = new ProjectResponseDTO("Project Data fatch successfully",projectService.getById(id));
        return new ResponseEntity<>(projectResponseDTO,HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ProjectResponseDTO> updateProject(@Valid @PathVariable long id, @RequestBody ProjectDTO projectDTO) {
        ProjectResponseDTO projectResponseDTO = new ProjectResponseDTO("data updated",projectService.updateProject(id, projectDTO));
        return  new ResponseEntity<>(projectResponseDTO,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable long id) {
        projectService.deleteById(id);
        return ResponseEntity.ok("Project with ID " + id + " has been deleted successfully.");
    }
}
