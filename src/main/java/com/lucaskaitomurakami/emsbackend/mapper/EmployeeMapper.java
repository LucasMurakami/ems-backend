package com.lucaskaitomurakami.emsbackend.mapper;

import com.lucaskaitomurakami.emsbackend.DTO.EmployeeDTO;
import com.lucaskaitomurakami.emsbackend.entity.Employee;
import org.springframework.beans.BeanUtils;

public class EmployeeMapper {

    public static EmployeeDTO mapToEmployeeDTO(Employee employee) {
        return new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartment().getId(),
                employee.getDepartment().getDepartmentName()
        );
    }

    public static Employee mapToEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        return employee;
    }
}
