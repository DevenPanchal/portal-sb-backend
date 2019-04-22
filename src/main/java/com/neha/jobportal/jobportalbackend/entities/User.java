package com.neha.jobportal.jobportalbackend.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	Long userid;

	@Column(length = 100, name = "username")
	@NotNull
	String username;

	@Column(length = 100, name = "email")
	@NotNull
	String email;

	@Column(length = 100, name = "name")
	@NotNull
	String name;

	@Column(length = 100, name = "location")
	@NotNull
	String location;

	@Column(name = "photo")
	String photo;

	@Column(name = "resume")
	String resume;

	@Column(name = "skills")
	String skills;

	@Column(name = "hashedpassword")
	String hashedpassword;

	@Column(length = 100, name = "role")
	@NotNull
	String role;

	@Column(length = 100, name = "education")
	@NotNull
	String education;
	
	 @ManyToMany(cascade = { CascadeType.MERGE })
	    @JoinTable(
	        name = "userjob", 
	        joinColumns = { @JoinColumn(name = "userid") }, 
	        inverseJoinColumns = { @JoinColumn(name = "jobid") }
	    )
	 @JsonIgnore
	Set<Job> jobs = new HashSet<>();
	
	

	/**
	 * @return the userid
	 */
	public Long getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return the resume
	 */
	public String getResume() {
		return resume;
	}

	/**
	 * @param resume the resume to set
	 */
	public void setResume(String resume) {
		this.resume = resume;
	}

	/**
	 * @return the skills
	 */
	public String getSkills() {
		return skills;
	}

	/**
	 * @param skills the skills to set
	 */
	public void setSkills(String skills) {
		this.skills = skills;
	}

	/**
	 * @return the hashedpassword
	 */
	public String getHashedpassword() {
		return hashedpassword;
	}

	/**
	 * @param hashedpassword the hashedpassword to set
	 */
	public void setHashedpassword(String hashedpassword) {
		this.hashedpassword = hashedpassword;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the education
	 */
	public String getEducation() {
		return education;
	}

	/**
	 * @param education the education to set
	 */
	public void setEducation(String education) {
		this.education = education;
	}

	public Set<Job> getJobs() {
		return jobs;
	}

	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}

}