package com.lucaskaitomurakami.emsbackend.mapper;

import com.lucaskaitomurakami.emsbackend.DTO.DepartmentDTO;
import com.lucaskaitomurakami.emsbackend.entity.Department;
import org.springframework.beans.BeanUtils;

public class DepartmentMapper {

    public static DepartmentDTO mapToDepartmentDTO(Department department) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        BeanUtils.copyProperties(department, departmentDTO);
        return departmentDTO;
    }

    public static Department mapToDepartment(DepartmentDTO departmentDTO) {
        Department department = new Department();
        BeanUtils.copyProperties(departmentDTO, department);
        return department;
    }

}
