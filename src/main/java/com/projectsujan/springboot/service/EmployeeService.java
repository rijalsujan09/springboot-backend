package com.projectsujan.springboot.service;

import java.util.List;

import com.projectsujan.springboot.entity.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee );
	
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeByID(long id);
	
	Employee updateEmployee(Employee employee, long id);
	
	void deleteEmployee(long id);

}
