package com.bridgelabz.employeepayrollapp.Service;
import com.bridgelabz.employeepayrollapp.DTO.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.Model.Employee;
import com.bridgelabz.employeepayrollapp.Repository.EmployeeRepo;
import com.bridgelabz.employeepayrollapp.exception.CostumException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
    public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    public Employee addEmployee(EmployeeDTO employeeDTO) {
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
}



