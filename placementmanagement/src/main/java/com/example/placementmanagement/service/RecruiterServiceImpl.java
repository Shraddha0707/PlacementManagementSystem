package com.example.placementmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.placementmanagement.dao.RecruiterRepository;
import com.example.placementmanagement.entity.Recruiter;
import com.example.placementmanagement.exception.RecruiterIdNotFoundException;

@Service
public class RecruiterServiceImpl implements RecruiterService {

	@Autowired
	private RecruiterRepository recruiterRepository;
	
	
	public RecruiterServiceImpl(RecruiterRepository theRecruiterRepository) {
		recruiterRepository=theRecruiterRepository;
	}

	@Override
	public List<Recruiter> findAll() {
		return recruiterRepository.findAll();
		
	}

	@Override
	public Recruiter findById(long recruiterId) throws RecruiterIdNotFoundException {
		Optional<Recruiter> result=recruiterRepository.findById(recruiterId);
		Recruiter theRecruiter=null;
		if(result.isPresent())
		{
			theRecruiter=result.get();
		}
		else
		{
			//we didn't find the recruiter
			throw new RecruiterIdNotFoundException("Did not find recruiter id -"+recruiterId);
		}
		return theRecruiter;
	}

	@Override
	public void save(Recruiter theRecruiter) {
		recruiterRepository.save(theRecruiter);
	}

	@Override
	public void deleteById(long recruiterId) {
		recruiterRepository.deleteById(recruiterId);
		
	}


}
