package com.example.placementmanagement.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.placementmanagement.dao.StudentRepository;
import com.example.placementmanagement.entity.Student;
import com.example.placementmanagement.exception.StudentEmailNotFoundException;
import com.example.placementmanagement.exception.StudentIdNotFoundException;


@Service
public class StudentServiceImpl implements StudentService{

@Autowired
private StudentRepository studentRepository;
	
	
	public StudentServiceImpl(StudentRepository theStudentRepository) {
		studentRepository=theStudentRepository;
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(long studentId) throws StudentIdNotFoundException {
		Optional<Student> result=studentRepository.findById(studentId);
		Student theStudent=null;
		if(result.isPresent())
		{
			theStudent=result.get();
		}
		else
		{
			//we didn't find the student
			throw new StudentIdNotFoundException("Did not find student id -"+studentId);
		}
		return theStudent;
	}

	@Override
	public void save(Student theStudent) {
		studentRepository.save(theStudent);
		
	}

	@Override
	public void deleteById(long studentId) {
		studentRepository.deleteById(studentId);
	}

	@Override
	public Student findByEmail(String email) throws StudentEmailNotFoundException {
		Optional<Student> result=Optional.of(studentRepository.findByEmail(email));
		Student theStudent=null;
		if(result.isPresent())
		{
			theStudent=result.get();
		}
		else
		{
			//we didn't find the student email
			throw new StudentEmailNotFoundException("Did not find student email -"+email);
		}
		return theStudent;
	}
}
