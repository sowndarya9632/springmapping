package com.bridgelabz.springmapping.service;

import com.bridgelabz.springmapping.dto.EmployeeDto;
import com.bridgelabz.springmapping.entity.Address;
import com.bridgelabz.springmapping.entity.Employee;
import com.bridgelabz.springmapping.exception.CustomException;
import com.bridgelabz.springmapping.repository.AddressRepository;
import com.bridgelabz.springmapping.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AddressRepository addressRepository;
    // @Autowired
   // private EmailService emailService;
    public EmployeeDto mapToDTO(Employee employee) {
        EmployeeDto requestDTO = new EmployeeDto();
        requestDTO.setFName(employee.getFName());
        requestDTO.setLName(employee.getLName());
        requestDTO.setAge(employee.getAge());
        requestDTO.setEmail(employee.getEmail());
        requestDTO.setDepartments(employee.getDepartments());
        requestDTO.setAddresses(employee.getAddresses());
        return requestDTO;
    }

    @Override
    public EmployeeDto addEmployee(EmployeeDto requestDto) {
        //emailService.sendEmail(requestDto.getEmail(), requestDto.getBody(), requestDto.getSubject());*/
        Employee employee = new Employee(requestDto);
        List<Address> address = requestDto.getAddresses();
        //address.forEach(add -> add.setEmployee(employee));
        for(Address addresses:address){
              addresses.setEmployee(employee);
          }
            employee.setAddresses(address);
            employee = employeeRepository.save(employee);
            return mapToDTO(employee);
        }


    @Override
    public EmployeeDto getEmployeeById(long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new CustomException("id not found"));
        return mapToDTO(employee);
    }

    @Override
    public EmployeeDto updateEmployeeById(EmployeeDto requestDto, long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setFName(requestDto.getFName());
            employee.setLName(requestDto.getLName());
            employee.setAge(requestDto.getAge());
            employee.setDepartments(requestDto.getDepartments());
            employee.setAddresses(requestDto.getAddresses());
            List<Address> addresses = requestDto.getAddresses();
            for(Address address:addresses){
                address.setEmployee(employee);
            }
            employee.setAddresses(addresses);
            employee = employeeRepository.save(employee);
            return mapToDTO(employee);
        }
        return null;
    }

    @Override
    public void deleteEmployeeById(long id) {

        employeeRepository.deleteById(id);
    }
}
