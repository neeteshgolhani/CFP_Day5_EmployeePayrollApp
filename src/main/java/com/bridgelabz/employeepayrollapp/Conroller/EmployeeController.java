package com.bridgelabz.employeepayrollapp.Conroller;
import com.bridgelabz.employeepayrollapp.DTO.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.DTO.ResponseDTO;
import com.bridgelabz.employeepayrollapp.Model.Employee;
import com.bridgelabz.employeepayrollapp.Service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addProject(@Valid @RequestBody EmployeeDTO employeeDTO) {
        log.info("Employee Data is adding");
        ResponseDTO responseDTO = new ResponseDTO( "Employee data added successfully", employeeService.addEmployee(employeeDTO));
        return  new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> findAllEmployees() {
        List<Employee> employeeDTOS = employeeService.findAllEmployees();
        return new ResponseEntity<>(employeeDTOS,HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseDTO> getEmployeeById(@PathVariable long id) {
        ResponseDTO responseDTO = new ResponseDTO("Employee Data Fetched Successfully", employeeService.getEmployeeById(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateEmployee(@PathVariable("id") long id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Data updated", employeeService.updateEmployee(id, employeeDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable long id) {
        boolean deleted = employeeService.deleteEmployee(id);
        if (deleted) {
            ResponseDTO responseDTO = new ResponseDTO("Employee Data Deleted Successfully", id);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } else {
            ResponseDTO responseDTO = new ResponseDTO("Employee Data Not Found", id);
            return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/department/{department}")
    public ResponseEntity<ResponseDTO>getElementByDepartment(@PathVariable String department){
        List<Employee>employeeList = employeeService.getEmployeeByDepartment(department);
        ResponseDTO responseDTO = new ResponseDTO("Get call for Department successfull",employeeList);
        return  new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}