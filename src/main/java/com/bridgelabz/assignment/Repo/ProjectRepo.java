package com.bridgelabz.assignment.Repo;
import com.bridgelabz.assignment.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends JpaRepository <Project, Long> {

}
