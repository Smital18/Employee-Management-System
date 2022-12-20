package com.wipro.controller;



import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.wipro.entity.Employee;
import com.wipro.exception.ResourceNotFoundException;
import com.wipro.repository.EmployeeRepository;
import com.wipro.service.EmployeeService;

@RestController
@CrossOrigin(origins="*")
public class EmployeeController {
	@Autowired
	//private EmployeeService service;
	private EmployeeRepository repository;
	@GetMapping("/employee")
	public Iterable<Employee>getEmployees()
	{
	return repository.findAll();    
	}
	 
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") long employeeId)
	throws ResourceNotFoundException{
	Employee employee = repository.findById(employeeId)
	.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
	return ResponseEntity.ok().body(employee);
	}

	@PostMapping(value = "/employee")
	private long saveEmployee(@Valid @RequestBody Employee employees)  
	{  
	repository.save(employees);  
	return  employees.getId();  
	}
   
  @PutMapping("/employee/{id}")
      public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") long employeeId,
           @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
           Employee employee = repository.findById(employeeId)
          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
           if(employeeDetails.getEmail()  != null)
           employee.setEmail(employeeDetails.getEmail());
          if(employeeDetails.getLastName()  != null)
            employee.setLastName(employeeDetails.getLastName());
          if(employeeDetails.getFirstName()  != null)
          employee.setFirstName(employeeDetails.getFirstName());
          if(employeeDetails.getPassword()  != null)
              employee.setPassword(employeeDetails.getPassword());
          if(employeeDetails.getPhone()  != null)
              employee.setPhone(employeeDetails.getPhone());
          if(employeeDetails.getLocation()  != null)
              employee.setLocation(employeeDetails.getLocation());
          
          
          final Employee updatedEmployee = repository.save(employee);
          
          return ResponseEntity.ok(updatedEmployee);
      }
     @DeleteMapping("/employee/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") long employeeId)
	throws ResourceNotFoundException {
	Employee employee = repository.findById(employeeId)
	.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
	repository.delete(employee);
	Map<String, Boolean> response = new HashMap<>();
	response.put("deleted", Boolean.TRUE);
	return response;
	}
	}

