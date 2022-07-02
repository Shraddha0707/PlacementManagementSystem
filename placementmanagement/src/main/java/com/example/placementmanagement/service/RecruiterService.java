package com.example.placementmanagement.service;

import java.util.List;

import com.example.placementmanagement.entity.Recruiter;
import com.example.placementmanagement.exception.RecruiterIdNotFoundException;

public interface RecruiterService {

		public List<Recruiter> findAll();
		
		public Recruiter findById(long recruiterId) throws RecruiterIdNotFoundException;
		
		public void save(Recruiter theRecruiter);
		
		public void deleteById(long recruiterId);

		
		
}
