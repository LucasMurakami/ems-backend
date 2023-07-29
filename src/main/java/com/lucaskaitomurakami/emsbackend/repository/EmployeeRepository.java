package com.lucaskaitomurakami.emsbackend.repository;

import com.lucaskaitomurakami.emsbackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
