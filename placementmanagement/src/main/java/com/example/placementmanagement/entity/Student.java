package com.example.placementmanagement.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

	@Entity
	@Table(name="student")
	public class Student 
	{
		
		@Id
		@GeneratedValue(generator="stuseq",strategy = GenerationType.AUTO)
		@SequenceGenerator(name="stuseq",initialValue=401)
		
		private long studentId;
		
		
		@ManyToOne (cascade = CascadeType.MERGE)
		@JoinColumn (name="jobApplicantId")
		private JobApplicant jobApplicant;
		
		@NotNull
		private String studentName;
		
		private String course;
		
		private String branch;
		
		private Date dateOfBirth;
		
		private float sscMarks;
		
		private float hscMarks;
		
		private float aggregateMarks;
		
		private String address;
		
		//@Length(min=10,max=13,message="Phone no cannot be less than 10 characters")
		@Pattern(regexp="^[0-9]{10}",message="Contact no should be of minimum 10 characters")
		private String contact;
		
		@Email
		private String email;
		
		@Pattern(regexp="^[0-9a-zA-Z]{8,16}",message="Password should be of minimum 8 or maximum 16 characters.")
		private String password;
		
		//Default constructor
		public Student() {
			super();
		}

		public Student(long studentId, JobApplicant jobApplicant, @NotNull String studentName, String course,
				String branch, Date dateOfBirth, float sscMarks, float hscMarks, float aggregateMarks, String address,
				@Pattern(regexp = "^[0-9]{10}", message = "Contact no should be of minimum 10 characters") String contact,
				@Email String email,
				@Pattern(regexp = "^[0-9a-zA-Z]{8,16}", message = "Password should be of minimum 8 or maximum 16 characters.") String password) {
			super();
			this.studentId = studentId;
			this.jobApplicant = jobApplicant;
			this.studentName = studentName;
			this.course = course;
			this.branch = branch;
			this.dateOfBirth = dateOfBirth;
			this.sscMarks = sscMarks;
			this.hscMarks = hscMarks;
			this.aggregateMarks = aggregateMarks;
			this.address = address;
			this.contact = contact;
			this.email = email;
			this.password = password;
		}

		public long getStudentId() {
			return studentId;
		}

		public void setStudentId(long studentId) {
			this.studentId = studentId;
		}

		public JobApplicant getJobApplicant() {
			return jobApplicant;
		}

		public void setJobApplicant(JobApplicant jobApplicant) {
			this.jobApplicant = jobApplicant;
		}

		public String getStudentName() {
			return studentName;
		}

		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}

		public String getCourse() {
			return course;
		}

		public void setCourse(String course) {
			this.course = course;
		}

		public String getBranch() {
			return branch;
		}

		public void setBranch(String branch) {
			this.branch = branch;
		}

		public Date getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public float getSscMarks() {
			return sscMarks;
		}

		public void setSscMarks(float sscMarks) {
			this.sscMarks = sscMarks;
		}

		public float getHscMarks() {
			return hscMarks;
		}

		public void setHscMarks(float hscMarks) {
			this.hscMarks = hscMarks;
		}

		public float getAggregateMarks() {
			return aggregateMarks;
		}

		public void setAggregateMarks(float aggregateMarks) {
			this.aggregateMarks = aggregateMarks;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getContact() {
			return contact;
		}

		public void setContact(String contact) {
			this.contact = contact;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public String toString() {
			return "Student [studentId=" + studentId + ", jobApplicant=" + jobApplicant + ", studentName=" + studentName
					+ ", course=" + course + ", branch=" + branch + ", dateOfBirth=" + dateOfBirth + ", sscMarks="
					+ sscMarks + ", hscMarks=" + hscMarks + ", aggregateMarks=" + aggregateMarks + ", address="
					+ address + ", contact=" + contact + ", email=" + email + ", password=" + password + "]";
		}

		
}
