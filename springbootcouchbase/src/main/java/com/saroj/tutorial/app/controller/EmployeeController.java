/**
 * 
 */
package com.saroj.tutorial.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saroj.tutorial.model.Employee;
import com.saroj.tutorial.model.MyResponse;
import com.saroj.tutorial.service.EmployeeService;

/**
 * @author sarojkumarrout
 * 
 */
@RestController
@RequestMapping("/tutorial")
public class EmployeeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
    EmployeeService empService;

	@RequestMapping(value = "/employee", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MyResponse> addEmployee(@RequestBody Employee employee) {
		MyResponse resp = new MyResponse();
		empService.create(employee);
		if(HttpStatus.OK.is2xxSuccessful()){
			resp.setStatus(HttpStatus.OK.value());
			resp.setMessage("Succesfuly created an employee object");
			return new ResponseEntity<MyResponse>(resp, HttpStatus.OK);
		}
		else{
			resp.setStatus(HttpStatus.OK.value());
			resp.setMessage("Error while creating an employee object");
			return new ResponseEntity<MyResponse>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@RequestMapping(value = "/employee", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getEmployeeFirstName(@RequestParam String firstName) {
		LOGGER.info("get the employee details");
		return empService.getEmployeeByFirstName(firstName);		
	}
	
	@RequestMapping(value = "/employee/{id}", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeById(@PathVariable String id) {
		LOGGER.info("get the employee details using empId");
		return empService.getEmployeeById(id);		
	}
	
	@RequestMapping(value = "/employee", method = { RequestMethod.DELETE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteEmployee(@RequestBody Employee emp) {
		empService.delete(emp);
	}

}
