package com.lucaskaitomurakami.emsbackend.service;

import com.lucaskaitomurakami.emsbackend.DTO.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(Long employeeId);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedEmployee);

    EmployeeDTO deleteEmployee(Long employeeId);
}
