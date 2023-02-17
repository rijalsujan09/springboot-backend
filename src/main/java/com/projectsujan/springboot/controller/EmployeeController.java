package com.projectsujan.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectsujan.springboot.entity.Employee;
import com.projectsujan.springboot.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService  employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	// building create  employee Rest API
	// http://localhost:8080/api/employees
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return  new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
		
	}
	
	
	//  building get Employee List Rest API
	// http://localhost:8080/api/employees
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	
	
	// building get Employee By ID REST API
	// http://localhost:8080/api/employees/id
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")  Long id){
		return  new  ResponseEntity<Employee>(employeeService.getEmployeeByID(id), HttpStatus.OK);
	}
	
	
	
	// building update Employee Rest API
	// http://localhost:8080/api/employees/id
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployeee(@PathVariable("id") Long id, 
			                                        @RequestBody Employee employee){
		return  new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);	
	}
	
	
	
	// building  Delete employee rest API
	// http://localhost:8080/api/employees/id
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
		
		//delete employee from database
		employeeService.deleteEmployee(id);
		
		return new ResponseEntity<String>("Employee Deleted sucessfull", HttpStatus.OK);	
	}

}
