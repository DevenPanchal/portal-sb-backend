package com.neha.jobportal.jobportalbackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.neha.jobportal.jobportalbackend.entities.Job;
import com.neha.jobportal.jobportalbackend.entities.User;
import com.neha.jobportal.jobportalbackend.repositories.JobRepository;
import com.neha.jobportal.jobportalbackend.repositories.UserRespository;

@Service
public class JobPortalCrudService {

	@Autowired
	private JobRepository jobRepository;
	@Autowired
	private UserRespository userRepository;

	@Transactional
	public List<Job> getJobs() {
		return jobRepository.findAll();
	}

	// Not every user must be able to see all users of the system. Change this later
	@Transactional
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public Job saveJob(Job newJob) {
		return jobRepository.save(newJob);
	}

	public void deleteJob(Long jobid) {
		jobRepository.deleteById(jobid);
	}

	public User saveUser(User newUser) {
		return userRepository.save(newUser);
	}

	public Optional<Job> getSingleJob(Long id) {
		return jobRepository.findById(id);

	}

	public List<Job> getFilteredJobsByLocation(String queryString) {
		return jobRepository.findJobsByLocation(queryString);
	}

	

	public List<Job> getFilteredJobsBySearchText(String queryString) {
		return jobRepository.findfilteredJobsByQueryString(queryString);

	}

//	public User saveAppliedJob(Job user) {
//		return userRepository.save(user);
//	}
}
