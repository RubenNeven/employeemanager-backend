package com.fullstack.employeemanager.service;

import com.fullstack.employeemanager.api.dto.EmployeeDto;
import com.fullstack.employeemanager.domain.Employee;
import com.fullstack.employeemanager.exception.UserNotFoundException;
import com.fullstack.employeemanager.repository.EmployeeRepository;
import com.fullstack.employeemanager.service.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    public EmployeeDto addEmployee(EmployeeDto employeeDTO){
        Employee employee = employeeMapper.mapToDomain(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto employeeDto = employeeMapper.mapToDto(savedEmployee);
        return employeeDto;
    }

    public Employee findEmployeeById(UUID id){
        return employeeRepository
                .findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by ID " + id + " was not found"));
    }

    public List<EmployeeDto> getAllEmployees(){
        return employeeRepository.findAll().stream()
                .map(employeeMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public EmployeeDto updateEmployee(EmployeeDto employeeDTO){
        Employee employee = employeeMapper.mapToDomain(employeeDTO);
        Employee updatedEmployee = employeeRepository.save(employee);
        return employeeMapper.mapToDto(updatedEmployee);

    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteEmployeeById(id);
    }
}
