package com.example.placementmanagement.entity;


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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Recruiter")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Recruiter {

	@Id
	@GeneratedValue(generator="recseq",strategy = GenerationType.AUTO )
	@SequenceGenerator(name="recseq",initialValue=301)
	private long recruiterId;
	
	@OneToMany(mappedBy="recruiter",fetch = FetchType.LAZY)
	@JsonIgnore
    private Collection<Job> job;
	
	@NotNull
	private String recruiterName;
	
	private String company;
	
	private String address;
	
	@Length(min=10,max=13,message="Phone no cannot be less than 10 characters")
	private String phoneNo;
	
	@Email
	private String email;
	
	private String website;
	
	private String password;
	
	public Recruiter() {
		super();
	}

	

	public Recruiter(long recruiterId, Collection<Job> job, @NotNull String recruiterName, String company,
			String address,
			@Length(min = 10, max = 13, message = "Phone no cannot be less than 10 characters") String phoneNo,
			@Email String email, String website, String password) {
		super();
		this.recruiterId = recruiterId;
		this.job = job;
		this.recruiterName = recruiterName;
		this.company = company;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
		this.website = website;
		this.password = password;
	}



	public long getRecruiterId() {
		return recruiterId;
	}

	public void setRecruiterId(long recruiterId) {
		this.recruiterId = recruiterId;
	}

	public Collection<Job> getJob() {
		return job;
	}

	public void setJob(Collection<Job> job) {
		this.job = job;
	}

	public String getRecruiterName() {
		return recruiterName;
	}

	public void setRecruiterName(String recruiterName) {
		this.recruiterName = recruiterName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public String getPhoneNo() {
		return phoneNo;
	}



	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "Recruiter [recruiterId=" + recruiterId + ", job=" + job + ", recruiterName=" + recruiterName
				+ ", company=" + company + ", address=" + address + ", phoneNo=" + phoneNo + ", email=" + email
				+ ", website=" + website + ", password=" + password + "]";
	}

	
}