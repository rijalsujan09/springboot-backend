package com.projectsujan.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectsujan.springboot.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
