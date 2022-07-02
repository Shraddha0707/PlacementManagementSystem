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

import com.example.placementmanagement.entity.Job;
import com.example.placementmanagement.exception.JobIdNotFoundException;
import com.example.placementmanagement.service.JobService;



@RestController  //The RestController allows to handle all REST APIs.
@RequestMapping("/joo")  //used to map web requests onto specific handler classes/methods
public class JobRestController {

	@Autowired  //used for dependency injection
	private JobService jobService;
	
	
	public JobRestController(JobService theJobService) {
		jobService = theJobService;
	}
	
	// expose "/Jobs" and return list of job
	@GetMapping("/jobs")
	public List<Job> findAll() {
		return jobService.findAll();
	}
	
	

	// add mapping for GET /Jobs/{JobId}
	
	@GetMapping("/jobs/{jobId}")
	public Job getJob(@Valid @PathVariable long jobId) throws JobIdNotFoundException {
		
		Job theJob = jobService.findById(jobId);
		
		if (theJob == null) {
			throw new JobIdNotFoundException("job id not found - " + jobId);
		}
		
		return theJob;
	}
	
	
	
	// add mapping for POST /Jobs - add new job
	
	@PostMapping("/jobs")
	public Job addJob(@Valid @RequestBody Job theJob) {
		
		theJob.setJobId(0);
		
		jobService.save(theJob);
		
		return theJob;
	}
	
	
	
	// add mapping for PUT /Jobs - update existing job
	
	@PutMapping("/jobs")
	public Job updateJob(@Valid @RequestBody Job theJob) {
		
		jobService.save(theJob);
		
		return theJob;
	}
	
	
	
	// add mapping for DELETE /Jobs/{JobId} - delete Job
	
	@DeleteMapping("/jobs/{jobId}")
	public String deleteJob(@Valid @PathVariable long jobId) throws JobIdNotFoundException {
		
		Job tempJob = jobService.findById(jobId);
		
		// throw exception if null
		
		if (tempJob == null) {
			throw new JobIdNotFoundException("Job id not found - " + jobId);
		}
		
		jobService.deleteById(jobId);
		
		return "Deleted Job id - " + jobId;
	}
	
}
