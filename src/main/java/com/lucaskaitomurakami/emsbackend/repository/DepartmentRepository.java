package com.lucaskaitomurakami.emsbackend.repository;

import com.lucaskaitomurakami.emsbackend.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
