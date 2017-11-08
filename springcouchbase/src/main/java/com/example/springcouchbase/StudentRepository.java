package com.example.springcouchbase;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, String>{
	
	List<Student> getStudentByFirstName(String fName);
}
