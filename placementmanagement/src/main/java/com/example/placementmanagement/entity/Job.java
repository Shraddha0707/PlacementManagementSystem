package com.example.placementmanagement.entity;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity  //This class is an entity mapped to database
@Table(name="job") 
public class Job {

	@Id
	@GeneratedValue(generator="joseq",strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="joseq",initialValue=101)
	private long jobId;
	
	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "recruiterId")
	private Recruiter recruiter;
	
	@JoinColumn (name="jobApplicantId")
	@ManyToOne (cascade = CascadeType.MERGE)
	private JobApplicant jobApplicant;
	
	
	private String company;
	
	private String jobDescription;	
	
	private Date startDate;
	
	private Date endDate;
	
	private String status;
	
	private String jobLocation;
	
	private long salary;
	
	private String jobRole;

	public Job() {
		super();
	}

	public Job(long jobId, Recruiter recruiter, JobApplicant jobApplicant, String company, String jobDescription,
			Date startDate, Date endDate, String status, String jobLocation, long salary, String jobRole) {
		super();
		this.jobId = jobId;
		this.recruiter = recruiter;
		this.jobApplicant = jobApplicant;
		this.company = company;
		this.jobDescription = jobDescription;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.jobLocation = jobLocation;
		this.salary = salary;
		this.jobRole = jobRole;
	}





	public long getJobId() {
		
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	public JobApplicant getJobApplicant() {
		return jobApplicant;
	}

	public void setJobApplicant(JobApplicant jobApplicant) {
		this.jobApplicant = jobApplicant;
	}

	

	public Recruiter getRecruiter() {
		return recruiter;
	}



	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}



	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}





	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", recruiter=" + recruiter + ", jobApplicant=" + jobApplicant + ", company="
				+ company + ", jobDescription=" + jobDescription + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", status=" + status + ", jobLocation=" + jobLocation + ", salary=" + salary + ", jobRole=" + jobRole
				+ "]";
	}

	

	
}
