package com.example.placementmanagement.service;

import java.util.List;
import com.example.placementmanagement.entity.Student;
import com.example.placementmanagement.exception.StudentEmailNotFoundException;
import com.example.placementmanagement.exception.StudentIdNotFoundException;

public interface StudentService {
	
	public List<Student> findAll();
	
	public Student findById(long studentId) throws StudentIdNotFoundException;
	
	public void save(Student thestudent);
	
	public void deleteById(long StudentId);
	
	public Student findByEmail(String email) throws StudentEmailNotFoundException;
}
