package com.lucaskaitomurakami.emsbackend.controller;

import com.lucaskaitomurakami.emsbackend.DTO.DepartmentDTO;
import com.lucaskaitomurakami.emsbackend.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    // Build Create or Add Department REST API
    @PostMapping()
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO department = departmentService.createDepartment(departmentDTO);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    // Build Get Department REST API
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable("id") Long departmentId) {
        DepartmentDTO departmentDTO = departmentService.getDepartment(departmentId);
        return ResponseEntity.ok(departmentDTO);
    }

    // Build Get All Departments REST API
    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        List<DepartmentDTO> list = departmentService.getAllDepartments();
        return ResponseEntity.ok(list);
    }

    // Build Update Department REST API
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDTO> updateDeparment(@PathVariable("id") Long departmentId, @RequestBody DepartmentDTO updatedDepartment) {
        DepartmentDTO departmentDTO = departmentService.updateDeparment(departmentId, updatedDepartment);
        return ResponseEntity.ok(departmentDTO);
    }

    // Build Delete Department REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<DepartmentDTO> deleteDepartment(@PathVariable("id") Long departmentId) {
        DepartmentDTO departmentDTO = departmentService.deleteDepartment(departmentId);
        return new ResponseEntity<>(departmentDTO, HttpStatus.NO_CONTENT);
    }
}
