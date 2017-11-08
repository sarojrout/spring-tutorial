package com.example.springcouchbase.service;

import java.util.List;

import com.example.springcouchbase.Student;

public interface StudentService {
	
	List<Student> getStudentByFirstName(String fName);
	Student getStudentById(String id);
	void create(Student student);
	void delete(Student student);

}
