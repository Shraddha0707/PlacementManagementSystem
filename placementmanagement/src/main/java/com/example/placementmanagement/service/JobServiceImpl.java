package com.example.placementmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.placementmanagement.dao.JobRepository;
import com.example.placementmanagement.entity.Job;
import com.example.placementmanagement.exception.JobIdNotFoundException;

@Service
public class JobServiceImpl implements JobService{

	@Autowired
	private JobRepository jobRepository;
	
	
	public JobServiceImpl(JobRepository theJobRepository) {
		jobRepository=theJobRepository;
	}

	@Override
	public List<Job> findAll() {
		return jobRepository.findAll();
		
	}

	@Override
	public Job findById(long jobId) throws JobIdNotFoundException {
		Optional<Job> result=jobRepository.findById(jobId);
		Job thejob=null;
		if(result.isPresent())
		{
			thejob=result.get();
		}
		else
		{
			//we didn't find the jobId
			throw new JobIdNotFoundException("Did not find job id -"+jobId);
		}
		return thejob;
	}

	@Override
	public void save(Job thejob) {
		
		jobRepository.save(thejob);
	}

	@Override
	public void deleteById(long jobId) {
		
		jobRepository.deleteById(jobId);
	}
}
