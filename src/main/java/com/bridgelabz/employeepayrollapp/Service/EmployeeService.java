package com.bridgelabz.employeepayrollapp.Service;
import com.bridgelabz.employeepayrollapp.DTO.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.Model.Employee;
import com.bridgelabz.employeepayrollapp.Repository.EmployeeRepo;
import com.bridgelabz.employeepayrollapp.exception.CostumException;
import com.bridgelabz.employeepayrollapp.exception.DuplicateEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
    public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    public Employee addEmployee(EmployeeDTO employeeDTO) {
        // Check if the email already exists in the database
        String email = employeeDTO.email;
        if (employeeRepo.existsByEmail(email)) {
            throw new DuplicateEmailException("Email '" + email + "' is already taken. Please use a different email.");
        }

        // Email is not present in the database, so create and save the new employee
        Employee employeeData = new Employee(employeeDTO);
        return employeeRepo.save(employeeData);
    }
    public Employee getEmployeeById(long id) {
        return employeeRepo.findById(id).orElseThrow(() -> new CostumException("Employee with ID: " + id + " not found"));
    }

    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee employeeData =getEmployeeById(id);
        if (employeeData != null) {
            employeeData.updateEmployee(employeeDTO);
            return employeeRepo.save(employeeData);
        }
        return null;
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public boolean deleteEmployee(long id) {
        // Check if the employee exists
        if (employeeRepo.existsById(id)) {
            employeeRepo.deleteById(id);
            return true; // Deletion successful
        }
        return false; // Employee not found
    }

    public List<Employee> getEmployeeByDepartment(String departments) {
      return employeeRepo.findEmployeeByDepartment(departments);
    }
}



