package com.example.springcouchbase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springcouchbase.entity.Student;
import com.example.springcouchbase.repo.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public List<Student> getStudentByFirstName(String fName) {
		
		return studentRepo.getStudentByFirstName(fName);
	}

	@Override
	public Student getStudentById(String id) {
		// TODO Auto-generated method stub
		return studentRepo.findOne(id);
	}

	@Override
	public void create(Student student) {
		studentRepo.save(student);
		
	}

	@Override
	public void delete(Student student) {
		studentRepo.delete(student);
		
	}

}
