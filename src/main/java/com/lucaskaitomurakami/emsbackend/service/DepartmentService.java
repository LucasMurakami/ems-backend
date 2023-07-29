package com.lucaskaitomurakami.emsbackend.service;

import com.lucaskaitomurakami.emsbackend.DTO.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    DepartmentDTO createDepartment(DepartmentDTO departmentDTO);

    DepartmentDTO getDepartment(Long departmentId);

    List<DepartmentDTO> getAllDepartments();

    DepartmentDTO updateDeparment(Long departmentId, DepartmentDTO updatedDepartment);

    DepartmentDTO deleteDepartment(Long departmentId);
}
