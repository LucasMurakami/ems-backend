package com.lucaskaitomurakami.emsbackend.service.implementation;

import com.lucaskaitomurakami.emsbackend.DTO.EmployeeDTO;
import com.lucaskaitomurakami.emsbackend.entity.Department;
import com.lucaskaitomurakami.emsbackend.entity.Employee;
import com.lucaskaitomurakami.emsbackend.exception.ResourceNotFoundException;
import com.lucaskaitomurakami.emsbackend.mapper.EmployeeMapper;
import com.lucaskaitomurakami.emsbackend.repository.DepartmentRepository;
import com.lucaskaitomurakami.emsbackend.repository.EmployeeRepository;
import com.lucaskaitomurakami.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImplementation implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);

        Department department = departmentRepository.findById(employeeDTO.getDepartmentId())
                .orElseThrow( () -> new ResourceNotFoundException("Department doesn't exist with id: " + employeeDTO.getDepartmentId()));

        employee.setDepartment(department);

        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeDTO getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow( () -> new ResourceNotFoundException("Employee doesn't exist with id: " + employeeId));

        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map( (employee) -> EmployeeMapper.mapToEmployeeDTO(employee)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee doesn't exist with id: " + employeeId)
        );

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Department department = departmentRepository.findById(updatedEmployee.getDepartmentId())
                .orElseThrow( () -> new ResourceNotFoundException("Department doesn't exist with id: " + updatedEmployee.getDepartmentId()));

        employee.setDepartment(department);

        Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDTO(updatedEmployeeObj);
    }

    @Override
    @Transactional
    public EmployeeDTO deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee doesn't exist with id: " + employeeId)
        );

        employeeRepository.deleteById(employeeId);
        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

}
