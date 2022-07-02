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


import com.example.placementmanagement.entity.JobApplicant;
import com.example.placementmanagement.exception.JobApplicantIdNotFoundException;
import com.example.placementmanagement.service.JobApplicantService;

@RestController  //The RestController allows to handle all REST APIs.
@RequestMapping("/jap") //used to map web requests onto specific handler classes/methods
public class JobApplicantRestController {

	
	@Autowired //used for dependency injection
	private JobApplicantService jobApplicantService;
	
	public JobApplicantRestController(JobApplicantService theJobApplicantService) {
		jobApplicantService = theJobApplicantService;
	}
	
	
	// expose "/jobApplicants" and return list of jobapplicant
	@GetMapping("/jobApplicants") //maps HTTP GET requests onto specific handler methods.
	public List<JobApplicant> findAll() {
		return jobApplicantService.findAll();
	}
	
	@GetMapping("/jobApplicantsHired/{status}") //maps HTTP GET requests onto specific handler methods.
	public List<JobApplicant> findByStatusHired() {
		return jobApplicantService.findByStatusHired();
	}
	
	@GetMapping("/jobApplicantsNotHired/{status}") //maps HTTP GET requests onto specific handler methods.
	public List<JobApplicant> findByStatusNotHired() {
		return jobApplicantService.findByStatusNotHired();
	}

	// add mapping for GET /JobApplicants/{JobApplicantId}
	
	@GetMapping("/jobApplicants/{jobApplicantId}") 
	public JobApplicant getJobApplicant(@Valid @PathVariable long jobApplicantId) throws JobApplicantIdNotFoundException {
		
		JobApplicant theJobApplicant =jobApplicantService.findById(jobApplicantId);
		
		if (theJobApplicant == null) {
			throw new JobApplicantIdNotFoundException("JobApplicant id not found - " + jobApplicantId);
		}
		
		return theJobApplicant;
	}
	
	
	
	// add mapping for POST /JobApplicants - add new JobApplicant
	
	@PostMapping("/jobApplicants")  //acts as a shortcut for @RequestMapping(method = RequestMethod. POST).
	public JobApplicant addJobApplicant(@Valid @RequestBody JobApplicant theJobApplicant) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		theJobApplicant.setJobApplicantId(0);
		
		jobApplicantService.save(theJobApplicant);
		
		return theJobApplicant;
	}
	
	
	
	// add mapping for PUT /jobApplicants - update existing jobApplicants
	
	@PutMapping("/jobApplicants")  //acts as a shortcut for @RequestMapping(method = RequestMethod. POST).
	public JobApplicant updateJobApplicant( @Valid @RequestBody JobApplicant theJobApplicant) {
		
		jobApplicantService.save(theJobApplicant);
		
		return theJobApplicant;
	}
	
	
	
	// add mapping for DELETE /JobApplicants/{JobApplicantId} - delete JobApplicant
	
	@DeleteMapping("/jobApplicants/{jobApplicantId}")   //HTTP DELETE requests onto specific handler methods
	public String deleteJobApplicant( @Valid @PathVariable long jobApplicantId) throws JobApplicantIdNotFoundException {
		
		JobApplicant tempJobApplicant = jobApplicantService.findById(jobApplicantId);
		
		// throw exception if null
		
		if (tempJobApplicant == null) {
			throw new JobApplicantIdNotFoundException("JobApplicant id not found - " + jobApplicantId);
		}
		
		jobApplicantService.deleteById(jobApplicantId);
		
		return "Deleted JobApplicant id - " + jobApplicantId;
	}

	
}
