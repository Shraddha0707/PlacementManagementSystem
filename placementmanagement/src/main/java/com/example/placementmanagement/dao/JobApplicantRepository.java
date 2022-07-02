package com.example.placementmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.placementmanagement.entity.JobApplicant;

@Repository
public interface JobApplicantRepository extends JpaRepository<JobApplicant, Long>{
	
	@Query(value = "SELECT * FROM job_Applicant WHERE status ='Hired'",nativeQuery = true)
	public List<JobApplicant> findByStatusHired();
	
	@Query(value = "SELECT * FROM job_Applicant WHERE status !='Hired'",nativeQuery = true)
	public List<JobApplicant> findByStatusNotHired();
}
