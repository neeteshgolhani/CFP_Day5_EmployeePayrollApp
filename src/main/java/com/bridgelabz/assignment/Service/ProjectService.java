package com.bridgelabz.assignment.Service;

import com.bridgelabz.assignment.DTO.ProjectDTO;
import com.bridgelabz.assignment.DTO.ProjectResponseDTO;
import com.bridgelabz.assignment.Exception.CostumException;
import com.bridgelabz.assignment.Model.Project;
import com.bridgelabz.assignment.Repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo projectRepo;

    public Project addProject(ProjectDTO projectDTO) {
        Project projectData = new Project(projectDTO);
        return projectRepo.save(projectData);
    }

    public Project getById(long id) {
        return projectRepo.findById(id).orElseThrow(() -> new CostumException("Project Data with id :" + id + " is not present"));
    }

    public ProjectResponseDTO getAllProject() {
        return null;
    }

    public Project updateProject(Long id, ProjectDTO projectDTO) {
        Project projectData = getById(id);
        if (projectData != null) {
            projectData.updateProject(projectDTO);
            return projectRepo.save(projectData);
        }
        return null;
    }

    public ResponseEntity<String> deleteById(long id) {
        if (projectRepo.existsById(id)) {
            projectRepo.deleteById(id);

            return ResponseEntity.ok("Task Deleted Successfully");
        }
        return null;
    }

}


