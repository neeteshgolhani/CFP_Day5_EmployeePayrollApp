package com.bridgelabz.employeepayrollapp.Repository;

import com.bridgelabz.employeepayrollapp.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    @Query(value = "SELECT * FROM employee_data,employee_dep WHERE id=employee_id and department = :department",nativeQuery = true)
    List<Employee> findEmployeeByDepartment(String department);
    boolean existsByEmail(String email);
}
