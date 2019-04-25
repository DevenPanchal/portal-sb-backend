package com.neha.jobportal.jobportalbackend.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import javax.persistence.JoinColumn;
@Entity
@Table(name = "user")
@Scope("session")
public class User implements UserDetails {

	public User() {
	
	}

	public User(Long userid, @NotNull String username, @NotNull String name, @NotNull String location, String photo,
			String resume, String skills, String password, @NotNull String role, @NotNull String education,
			Set<Job> jobs) {
		
		this.userid = userid;
		this.username = username;
		this.name = name;
		this.location = location;
		this.photo = photo;
		this.resume = resume;
		this.skills = skills;
		this.password = password;
		this.role = role;
		this.education = education;
		this.jobs = jobs;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	Long userid;

	// This is in fact the email user enters on the screen.
	@Column(length = 100, name = "username",unique = true)
	@NotNull
	String username;


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

	@Column(name = "password")
	@JsonProperty(access = Access.WRITE_ONLY)
	String password;

	@Column(length = 100, name = "role")
	@NotNull
	String role;

	@Column(length = 100, name = "education")
	@NotNull
	
	String education;
	
	 @ManyToMany(cascade = { CascadeType.MERGE },fetch = FetchType.EAGER)
	    @JoinTable(
	        name = "userjob", 
	        joinColumns = { @JoinColumn(name = "userid") }, 
	        inverseJoinColumns = { @JoinColumn(name = "jobid") }
	    )
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", name=" + name + ", location=" + location
				+ ", photo=" + photo + ", resume=" + resume + ", skills=" + skills + ", password=" + password
				+ ", role=" + role + ", education=" + education + ", jobs=" + jobs + "]";
	}

	

	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role));
		return authorities;
	}

	
}