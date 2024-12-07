package com.bridgelabz.springmapping.service;

import com.bridgelabz.springmapping.dto.EmployeeDto;

public interface EmployeeService {
   EmployeeDto addEmployee(EmployeeDto Resquest);
   EmployeeDto getEmployeeById(long id);
   EmployeeDto updateEmployeeById(EmployeeDto requestDto, long id);
   void deleteEmployeeById(long id);
}
