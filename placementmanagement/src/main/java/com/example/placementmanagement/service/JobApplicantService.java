package com.example.placementmanagement.service;

import java.util.List;

import com.example.placementmanagement.entity.JobApplicant;
import com.example.placementmanagement.exception.JobApplicantIdNotFoundException;

public interface JobApplicantService {

	public List<JobApplicant> findAll();
	
	public JobApplicant findById(long jobApplicantId) throws JobApplicantIdNotFoundException;
	
	public void save(JobApplicant thejobApplicant);
	
	public void deleteById(long jobApplicantId);
	
	public List<JobApplicant> findByStatusHired();
	
	public List<JobApplicant> findByStatusNotHired();
}
