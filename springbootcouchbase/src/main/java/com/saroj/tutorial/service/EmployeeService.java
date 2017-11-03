/**
 * 
 */
package com.saroj.tutorial.service;

import java.util.List;

import com.saroj.tutorial.model.Employee;

/**
 * @author sarojkumarrout
 *
 */
public interface EmployeeService {
	
	 List<Employee> getAllEmployees();
	 Employee getEmployeeById(String id);
	 List<Employee> getEmployeeByFirstName(String firstName);
	 void create(Employee emp);
	 void update(Employee emp);
	 void delete(Employee emp);

}
