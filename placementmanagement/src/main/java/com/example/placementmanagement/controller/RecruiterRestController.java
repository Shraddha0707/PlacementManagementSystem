package com.example.placementmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.placementmanagement.entity.Recruiter;
import com.example.placementmanagement.exception.RecruiterIdNotFoundException;
import com.example.placementmanagement.service.RecruiterService;

@RestController
@RequestMapping("/roo")

public class RecruiterRestController {
	
	@Autowired
	private RecruiterService recruiterService;
	
	public RecruiterRestController(RecruiterService theRecruiterService) {
		recruiterService = theRecruiterService;
	}
	
	// expose "/recruiters" and return list of recruiters
	@GetMapping("/recruiters")
	public List<Recruiter> findAll() {
		return recruiterService.findAll();
	}
	
	

	// add mapping for GET /recruiters/{recruiterId}
	
	@GetMapping("/recruiters/{recruiterId}")
	public Recruiter getRecruiter(@Valid @PathVariable long recruiterId) throws RecruiterIdNotFoundException {
		
		Recruiter theRecruiter =recruiterService.findById(recruiterId);
		
		if (theRecruiter == null) {
			throw new RecruiterIdNotFoundException("Recruiter id not found - " + recruiterId);
		}
		
		return theRecruiter;
	}
	
	
	
	// add mapping for POST /recruiters - add new recruiter
	
	@PostMapping("/recruiters")
	public Recruiter addRecruiter(@Valid @RequestBody Recruiter theRecruiter) {
	
		theRecruiter.setRecruiterId(0);
		
		recruiterService.save(theRecruiter);
		
		return theRecruiter;
	}
	
	
	
	// add mapping for PUT /Recruiters - update existing Recruiter
	
	@PutMapping("/recruiters")
	public Recruiter updateRecruiter(@Valid @RequestBody Recruiter theRecruiter) {
		
		recruiterService.save(theRecruiter);
		
		return theRecruiter;
	}
	
	
	
	// add mapping for DELETE /Recruiters/{RecruiterId} - delete Recruiter
	
	@DeleteMapping("/recruiters/{recruiterId}")
	public String deleteRecruiter(@Valid @PathVariable long recruiterId) throws RecruiterIdNotFoundException {
		
		Recruiter tempRecruiter = recruiterService.findById(recruiterId);
		
		// throw exception if null
		
		if (tempRecruiter == null) {
			throw new RecruiterIdNotFoundException("Recruiter id not found - " +recruiterId);
		}
		
		recruiterService.deleteById(recruiterId);
		
		return "Deleted recruiter id - " + recruiterId;
	}
	
	
	
}