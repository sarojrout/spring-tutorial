package com.example.springcouchbase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcouchbase.entity.Student;
import com.example.springcouchbase.service.StudentService;

@RestController
@RequestMapping("/sarojtutorial")
public class StudentController {
	
	@RequestMapping(value = "/student", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addStudent(@RequestBody Student student) {
		service.create(student);
	}
	@Autowired
	StudentService service;
	@RequestMapping(value = "/student", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getStudentFirstName(@RequestParam String firstName) {
		return service.getStudentByFirstName(firstName);		
	}
	
	@RequestMapping(value = "/student/{id}", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
	public Student getStudenteById(@PathVariable String id) {
		return service.getStudentById(id);		
	}
	
	@RequestMapping(value = "/student", method = { RequestMethod.DELETE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteStudent(@RequestBody Student student) {
		 service.delete(student);	
	}


}
