package com.lucaskaitomurakami.emsbackend.service.implementation;

import com.lucaskaitomurakami.emsbackend.DTO.DepartmentDTO;
import com.lucaskaitomurakami.emsbackend.entity.Department;
import com.lucaskaitomurakami.emsbackend.exception.ResourceNotFoundException;
import com.lucaskaitomurakami.emsbackend.mapper.DepartmentMapper;
import com.lucaskaitomurakami.emsbackend.repository.DepartmentRepository;
import com.lucaskaitomurakami.emsbackend.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentServiceImplementation implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        Department department = DepartmentMapper.mapToDepartment(departmentDTO);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDTO(savedDepartment);
    }

    @Override
    @Transactional(readOnly = true)
    public DepartmentDTO getDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department doesn't exist with the id: " + departmentId)
        );

        return DepartmentMapper.mapToDepartmentDTO(department);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentDTO> list = departmentRepository.findAll().stream().map( (department) -> DepartmentMapper.mapToDepartmentDTO(department)).toList();
        return list;
    }

    @Override
    @Transactional
    public DepartmentDTO updateDeparment(Long departmentId, DepartmentDTO updatedDepartment) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department doesn't exist with the id: " + departmentId)
        );

        department.setDepartmentName(updatedDepartment.getDepartmentName());
        department.setDepartmentDescription(updatedDepartment.getDepartmentDescription());

        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDTO(savedDepartment);

    }

    @Override
    @Transactional
    public DepartmentDTO deleteDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department doesn't exist with the id: " + departmentId)
        );

        departmentRepository.deleteById(departmentId);
        return DepartmentMapper.mapToDepartmentDTO(department);
    }

}
