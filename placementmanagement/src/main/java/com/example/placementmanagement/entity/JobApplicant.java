package com.example.placementmanagement.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="JobApplicant")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class JobApplicant {

	@Id
	@GeneratedValue(generator="japseq",strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="japseq",initialValue=201)
	private long jobApplicantId;
	
	@OneToMany(mappedBy = "jobApplicant",fetch = FetchType.LAZY)
	@JsonIgnore
    private Collection<Student> student;

	@OneToMany(mappedBy = "jobApplicant", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
    private Collection<Job> job;

	String applicantName;
	
	private String jobRole;
	
	private String company;
	
	private String location;
	
	private String status;
	
	private String recruiterAction;
	
	public JobApplicant() {
		super();
	}

	public JobApplicant(long jobApplicantId, Collection<Student> student, Collection<Job> job, String applicantName,
			String jobRole, String company, String location, String status, String recruiterAction) {
		super();
		this.jobApplicantId = jobApplicantId;
		this.student = student;
		this.job = job;
		this.applicantName = applicantName;
		this.jobRole = jobRole;
		this.company = company;
		this.location = location;
		this.status = status;
		this.recruiterAction = recruiterAction;
	}

	public long getJobApplicantId() {
		return jobApplicantId;
	}

	public void setJobApplicantId(long jobApplicantId) {
		this.jobApplicantId = jobApplicantId;
	}

	public Collection<Student> getStudent() {
		return student;
	}

	public void setStudent(Collection<Student> student) {
		this.student = student;
	}

	public Collection<Job> getJob() {
		return job;
	}

	public void setJob(Collection<Job> job) {
		this.job = job;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRecruiterAction() {
		return recruiterAction;
	}

	public void setRecruiterAction(String recruiterAction) {
		this.recruiterAction = recruiterAction;
	}

	@Override
	public String toString() {
		return "JobApplicant [jobApplicantId=" + jobApplicantId + ", student=" + student + ", job=" + job
				+ ", applicantName=" + applicantName + ", jobRole=" + jobRole + ", company=" + company + ", location="
				+ location + ", status=" + status + ", recruiterAction=" + recruiterAction + "]";
	}

	
	
}
