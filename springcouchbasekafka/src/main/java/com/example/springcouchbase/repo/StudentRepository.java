package com.example.springcouchbase.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.springcouchbase.entity.Student;

public interface StudentRepository extends CrudRepository<Student, String>{
	
	List<Student> getStudentByFirstName(String fName);
}
