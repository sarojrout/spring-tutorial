/**
 * 
 */
package com.saroj.tutorial.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.saroj.tutorial.model.Employee;

/**
 * @author sarojkumarrout
 *
 */
public interface EmployeeRepository extends CrudRepository<Employee, String> {
	List<Employee> findByFirstName(String firstName);

}
