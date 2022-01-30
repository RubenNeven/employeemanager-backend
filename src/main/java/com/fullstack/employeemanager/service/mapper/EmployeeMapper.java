package com.fullstack.employeemanager.service.mapper;

import com.fullstack.employeemanager.api.dto.EmployeeDto;
import com.fullstack.employeemanager.domain.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeDto mapToDto(Employee employee){
        return new EmployeeDto.EmployeeBuilder()
                .setId(employee.getId())
                .setName(employee.getName())
                .setEmail(employee.getEmail())
                .setPhone(employee.getPhone())
                .setJobTitle(employee.getJobTitle())
                .setEmployeeCode(employee.getEmployeeCode())
                .setImageUrl(employee.getImageUrl())
                .build();
    }

    public Employee mapToDomain(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getName(),
                employeeDto.getEmail(),
                employeeDto.getJobTitle(),
                employeeDto.getPhone(),
                employeeDto.getImageUrl());
    }
}
