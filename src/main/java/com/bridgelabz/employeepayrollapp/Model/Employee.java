package com.bridgelabz.employeepayrollapp.Model;
import com.bridgelabz.employeepayrollapp.DTO.EmployeeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_data")
public @Data class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    private String fName;
    private String lName;
    private String email;
    private String phoneNumber;
    private String address;
    private double salary;
    private String gender;
    private String profilePic;
    @Column(name="Joined_Date")

    private LocalDate startDate;
    private String notes;
    @ElementCollection
    @CollectionTable(name = "employee_dep", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "department")
    private List<String> department;
    public Employee(EmployeeDTO employeeDTO) {

        this.updateEmployee(employeeDTO);
    }
    public void updateEmployee(EmployeeDTO employeeDTO) {
        this.fName = employeeDTO.fName;
        this.lName = employeeDTO.lName;
        this.email = employeeDTO.email;
        this.phoneNumber = employeeDTO.phoneNumber;
        this.address = employeeDTO.address;
        this.salary = employeeDTO.salary;
        this.gender = employeeDTO.gender;
        this.profilePic = employeeDTO.profilePic;
        this.startDate = employeeDTO.startDate;
        this.notes = employeeDTO.notes;
        this.department=employeeDTO.department;
    }

}


