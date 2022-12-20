package com.wipro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.entity.Employee;
import com.wipro.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repo;
	public Iterable<Employee > getAll() {
        return this.repo.findAll();
    }
//saving a specific record by using the method save() of CrudRepository  
public void saveOrUpdate(Employee employees)  
{  
repo.save(employees);  
}
public Employee getEmployeeById(long id)  
{  
return repo.findById(id).get();  
}
public void update(Employee employees, int id)  
{  
repo.save(employees);  
}  
 
public void delete(long id)  
{  
repo.deleteById(id);  
}
 
}  
  
