package com.neha.jobportal.jobportalbackend.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "job")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jobid")
	Long jobid;

	@Column(length = 100, name = "title")
	@NotNull
	String title;

	@NotNull
	@Column(name = "description")
	String description;

	@Column(name = "keywords")
	String keywords;

	@Column(name = "location")
	String location;

	@Column(length = 100, name = "salaryrange")
	String salaryrange;

	@Column(length = 100, name = "postedby")

	String postedby;

	String image;

	
	@ManyToMany(mappedBy = "jobs")
	Set<User> users = new HashSet<>();

	/**
	 * @return the jobid
	 */
	public Long getJobid() {
		return jobid;
	}

	/**
	 * @param jobid the jobid to set
	 */
	public void setJobid(Long jobid) {
		this.jobid = jobid;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the keywords
	 */
	public String getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
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
	 * @return the salaryrange
	 */
	public String getSalaryrange() {
		return salaryrange;
	}

	/**
	 * @param salaryrange the salaryrange to set
	 */
	public void setSalaryrange(String salaryrange) {
		this.salaryrange = salaryrange;
	}

	/**
	 * @return the postedby
	 */
	public String getPostedby() {
		return postedby;
	}

	/**
	 * @param postedby the postedby to set
	 */
	public void setPostedby(String postedby) {
		this.postedby = postedby;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}