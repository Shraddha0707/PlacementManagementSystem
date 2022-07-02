package com.example.placementmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.placementmanagement.entity.Student;
import com.example.placementmanagement.exception.StudentEmailNotFoundException;
import com.example.placementmanagement.exception.StudentIdNotFoundException;
import com.example.placementmanagement.service.*;


@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	@Autowired
	private StudentService studentService;
	
	public StudentRestController(StudentService theStudentService) {
		studentService = theStudentService;
	}
	
	// expose "/Students" and return list of Students
	@GetMapping("/students")
	public List<Student> findAll() {
		return studentService.findAll();
	}
	
	

	// add mapping for GET /Students/{StudentId}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@Valid @PathVariable long studentId) throws StudentIdNotFoundException{
		
		Student theStudent = studentService.findById(studentId);
		
		if (theStudent == null) {
			throw new StudentIdNotFoundException("Student id not found - " + studentId);
		}
		
		return theStudent;
	}
	
	
	// add mapping for POST /Students - add new Student
	
	@PostMapping("/students")
	public Student addStudent(@Valid @RequestBody Student theStudent) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theStudent.setStudentId(0);
		
		studentService.save(theStudent);
		
		return theStudent;
	}
	
	
	
	// add mapping for PUT /Students - update existing Student
	
	@PutMapping("/students")
	public Student updateStudent(@Valid @RequestBody Student theStudent) {
		
		studentService.save(theStudent);
		
		return theStudent;
	}
	
	
	
	// add mapping for DELETE /Students/{StudentId} - delete Student
	
	@DeleteMapping("/students/{studentId}") 
	public String deleteStudent(@Valid @PathVariable long studentId) throws StudentIdNotFoundException{
		
		Student tempStudent = studentService.findById(studentId);
		
		if (tempStudent == null) {
			throw new StudentIdNotFoundException("Student id not found - " + studentId);
		}
		
		studentService.deleteById(studentId);
		
		return "Deleted student id - " + studentId;
	}
	
	//add mapping for finding student by email
	
	@GetMapping("/studentsByEmail/{email:.+}")
	public Student findByEmail(@PathVariable(name="email") String email) throws StudentEmailNotFoundException
	{
		System.out.println(email);
		Student student=studentService.findByEmail(email);
		return student;
		
	}
}