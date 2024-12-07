package com.bridgelabz.springmapping.entity;

import com.bridgelabz.springmapping.dto.EmployeeDto;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User_Data")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long emp_id;
    private String fName;
    private String lName;
    private int age;
    private LocalDate doj;
    private String email;
    @ElementCollection
    @CollectionTable(name = "department_data", joinColumns = @JoinColumn(name = "employee_id"))
    private List<String> departments;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Address> addresses;
   public Employee(EmployeeDto requestDTO) {
        this.fName = requestDTO.getFName();
        this.lName = requestDTO.getLName();
        this.email= requestDTO.getEmail();
        this.age=requestDTO.getAge();
        this.doj = LocalDate.now();
        this.departments = requestDTO.getDepartments();
    }
}
