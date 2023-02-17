package com.projectsujan.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projectsujan.springboot.entity.Employee;
import com.projectsujan.springboot.exception.ResourceNotFoundException;
import com.projectsujan.springboot.repository.EmployeeRepository;
import com.projectsujan.springboot.service.EmployeeService;

@Service
public class EmployeeServiceimpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeServiceimpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}
	

	@Override
	public List<Employee> getAllEmployees() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeByID(long id) {
		
		// also we can use this

//		Optional<Employee> employee  = employeeRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}
//		else {
//			throw new ResourceNotFoundException("Employee", "Id", id);
//		}

		return employeeRepository.findById(id).orElseThrow(() -> 
		                                       new ResourceNotFoundException("Employee", "Id", id));
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		// we need to check weather the employee with given id is exist in DB or not
		
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> 
        new ResourceNotFoundException("Employee", "Id", id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		// Saving the updated employee
		employeeRepository.save(existingEmployee);
	
		return existingEmployee;
	}
	
	
	

	@Override
	public void deleteEmployee(long id) {
		
		//check if the employee exist in the database or not
		employeeRepository.findById(id).orElseThrow(() -> 
        new ResourceNotFoundException("Employee", "Id", id));
		
		employeeRepository.deleteById(id);
	}

	
	
}
