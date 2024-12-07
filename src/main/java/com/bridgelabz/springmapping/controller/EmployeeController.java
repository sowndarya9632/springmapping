package com.bridgelabz.springmapping.controller;

import com.bridgelabz.springmapping.dto.EmployeeDto;
import com.bridgelabz.springmapping.service.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    private EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {

        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public EmployeeDto addEmployee(@Valid @RequestBody EmployeeDto requestDTO){
            return employeeService.addEmployee(requestDTO);
        }

        @GetMapping("/{id}")
        public EmployeeDto getEmployeeById(@PathVariable Long id){
            return employeeService.getEmployeeById(id);
        }
    @PutMapping("/{id}")
    public EmployeeDto updateEmployeeById(@Valid @RequestBody EmployeeDto requestDto, @PathVariable long id) {
        return employeeService.updateEmployeeById(requestDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable long id) {
        employeeService.deleteEmployeeById(id);
    }


}
