package com.example.springcouchbase.controller;

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

import com.example.kafka.producer.KafkaEventProducer;
import com.example.springcouchbase.entity.Student;
import com.example.springcouchbase.model.StudentResponse;
import com.example.springcouchbase.service.StudentService;

@RestController
@RequestMapping("/sarojtutorial")
public class StudentController {
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private KafkaEventProducer producer;
	@RequestMapping(value = "/student", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> addStudent(@RequestBody Student student) {
		LOGGER.info("Add student");
		producer.sendMessage(student);
		StudentResponse resp = new StudentResponse();
		resp.setMessage("successfully created the student object");
		resp.setStatus(HttpStatus.OK.value());
	//	service.create(student);
		return new ResponseEntity<StudentResponse>(resp, HttpStatus.OK);
	}
	@Autowired
	StudentService service;
	@RequestMapping(value = "/student", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getStudentFirstName(@RequestParam String firstName) {
		LOGGER.info("Find student by first name: {}", firstName);
		return service.getStudentByFirstName(firstName);		
	}
	
	@RequestMapping(value = "/student/{id}", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
	public Student getStudenteById(@PathVariable String id) {
		LOGGER.info("Find student by id: {}", id);
		return service.getStudentById(id);		
	}
	
	@RequestMapping(value = "/student", method = { RequestMethod.DELETE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteStudent(@RequestBody Student student) {
		LOGGER.info("delete student");
		 service.delete(student);	
	}


}
