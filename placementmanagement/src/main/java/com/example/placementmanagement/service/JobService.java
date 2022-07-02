package com.example.placementmanagement.service;

import java.util.List;

import com.example.placementmanagement.entity.Job;
import com.example.placementmanagement.exception.JobIdNotFoundException;

public interface JobService {

	public List<Job> findAll();
	
	public Job findById(long jobId) throws JobIdNotFoundException;
	
	public void save(Job thejob);
	
	public void deleteById(long jobId);
}
