package com.example.placementmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.placementmanagement.entity.Recruiter;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {
	
	
}
