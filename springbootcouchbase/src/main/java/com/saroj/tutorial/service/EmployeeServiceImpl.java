/**
 * 
 */
package com.saroj.tutorial.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saroj.tutorial.model.Employee;
import com.saroj.tutorial.repo.EmployeeRepository;

/**
 * @author sarojkumarrout
 * 
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> emplList = new ArrayList<Employee>();
		Iterator<Employee> iter = employeeRepo.findAll().iterator();
		while(iter.hasNext()){
			emplList.add(iter.next());
		}
		return emplList;

	}

	@Override
	public Employee getEmployeeById(String id) {
		return employeeRepo.findOne(id);
	}

	@Override
	public List<Employee> getEmployeeByFirstName(String firstName) {
		return employeeRepo.findByFirstName(firstName);
	}

	@Override
	public void create(Employee emp) {
		employeeRepo.save(emp);
		
	}

	@Override
	public void update(Employee emp) {
		employeeRepo.save(emp);
		
	}

	@Override
	public void delete(Employee emp) {
		employeeRepo.delete(emp);
		
	}

}
