package com.example.placementmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.placementmanagement.dao.JobApplicantRepository;
import com.example.placementmanagement.dao.StudentRepository;
import com.example.placementmanagement.entity.JobApplicant;
import com.example.placementmanagement.exception.JobApplicantIdNotFoundException;


@Service
public class JobApplicantServiceImpl implements JobApplicantService{
	
	@Autowired
	private JobApplicantRepository jobApplicantRepository;
	
	public JobApplicantServiceImpl(JobApplicantRepository theJobApplicantRepository) {
		jobApplicantRepository=theJobApplicantRepository;
	}

	@Override
	public List<JobApplicant> findAll() {
		return jobApplicantRepository.findAll();
		
	}

	@Override
	public JobApplicant findById(long jobApplicantId) throws JobApplicantIdNotFoundException {
		Optional<JobApplicant> result=jobApplicantRepository.findById((long) jobApplicantId);
		JobApplicant thejobApplicant=null;
		if(result.isPresent())
		{
			thejobApplicant=result.get();
		}
		else
		{
			//we didn't find the job applicant  ......
			throw new JobApplicantIdNotFoundException("Did not find Job Applicant id -"+jobApplicantId);
		}
		return thejobApplicant;
	}

	@Override
	public void save(JobApplicant thejobApplicant) {
		jobApplicantRepository.save(thejobApplicant);
		
	}

	@Override
	public void deleteById(long jobApplicantId) {
		jobApplicantRepository.deleteById(jobApplicantId);
		
	}

	@Override
	public List<JobApplicant> findByStatusHired() {
		
		return jobApplicantRepository.findByStatusHired();
	}

	@Override
	public List<JobApplicant> findByStatusNotHired() {
		
		return jobApplicantRepository.findByStatusNotHired();
	}

}
