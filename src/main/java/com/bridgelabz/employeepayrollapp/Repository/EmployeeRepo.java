package com.bridgelabz.employeepayrollapp.Repository;

import com.bridgelabz.employeepayrollapp.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    
}
