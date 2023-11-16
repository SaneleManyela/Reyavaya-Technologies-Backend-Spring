package com.reyavaya.Reyavaya.Technologies.controllers;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.reyavaya.Reyavaya.Technologies.Exception.ResourceNotFoundException;
import com.reyavaya.Reyavaya.Technologies.model.Employee;
import com.reyavaya.Reyavaya.Technologies.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployes() {
		return employeeRepository.findAll();
	}
	
	// create employee
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody LinkedHashMap<String, String> employee) {
		System.out.println(employee);
		Employee employeeObj = new Employee(
				employee.get("firstName"),
				employee.get("lastName"),
				employee.get("email"),
				employee.get("address"),
				employee.get("contactNo"),
				employee.get("password"),
				employee.get("username"),
				employee.get("role"));
		return employeeRepository.save(employeeObj);
	}
	
	// Get employee by id
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
				"Employee with id "+id+" doe not exist"));
		return ResponseEntity.ok(employee);
	}
	
	// Update employee
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
		
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee with id "+id+" does not exist"));
		
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmail(employeeDetails.getEmail());
		employee.setAddress(employeeDetails.getAddress());
		employee.setContactNo(employeeDetails.getContactNo());
		employee.setPassword(employeeDetails.getPassword());
		employee.setUsername(employeeDetails.getUsername());
		employee.setRole(employeeDetails.getRole());

		Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	// Delete employee
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
				"Employee with id "+id+" doe not exist"));
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
