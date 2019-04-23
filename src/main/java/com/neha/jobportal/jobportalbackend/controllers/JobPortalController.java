package com.neha.jobportal.jobportalbackend.controllers;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.neha.jobportal.jobportalbackend.entities.Job;
import com.neha.jobportal.jobportalbackend.entities.User;
import com.neha.jobportal.jobportalbackend.repositories.JobRepository;
import com.neha.jobportal.jobportalbackend.services.JobPortalCrudService;
import com.neha.jobportal.jobportalbackend.services.UserService;
import com.neha.jobportal.jobportalbackend.utils.CustomErrorType;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class JobPortalController {

	@Autowired
	private JobPortalCrudService jobPortalCrudService;


	

	@GetMapping("/jobs")
	@ResponseStatus(HttpStatus.OK)
	public List<Job> getJobs() {
		List<Job> alljobs = jobPortalCrudService.getJobs();
		return alljobs;
	}

	@GetMapping("/job/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Job> getSingleJob(@PathVariable Long id) {
		Optional<Job> singleJob = jobPortalCrudService.getSingleJob(id);
		return singleJob;
	}

	@GetMapping("/users")
	@ResponseStatus(HttpStatus.OK)
	public List<User> getUser() {
		List<User> allusers = jobPortalCrudService.getUsers();
		return allusers;
	}

	@PostMapping("/jobs")
	@ResponseStatus(HttpStatus.CREATED)
	public Job newJob(@RequestBody Job newJob) {
		/*
		 * Job postedJob = jobPortalCrudService.saveJob(newJob);
		 * 
		 * HttpHeaders responseHeaders = new HttpHeaders();
		 * responseHeaders.set("Access-Control-Allow-Origin", "*");
		 * responseHeaders.set("Access-Control-Allow-Methods", "*");
		 * responseHeaders.set("Access-Control-Allow-Headers", "*");
		 * 
		 * return ResponseEntity.ok().headers(responseHeaders).body(postedJob);
		 */

		return jobPortalCrudService.saveJob(newJob);
	}

	@PostMapping("/jobs/delete/{jobid}")
	public ResponseEntity<String> deleteJob(@PathVariable Long jobid) {
		jobPortalCrudService.deleteJob(jobid);
		return new ResponseEntity("Deleted successfully!", HttpStatus.OK);
	}

	@PostMapping("/users")
	@ResponseStatus(HttpStatus.CREATED)
	public User newUser(@RequestBody User newUser) {
		return jobPortalCrudService.saveUser(newUser);
	}

	@GetMapping("/filter-jobs-by-location")
	@ResponseStatus(HttpStatus.OK)
	public List<Job> getFilteredJobsByLocation(@RequestParam(name = "location") String queryString) {
		List<Job> filteredJobsByLocation = jobPortalCrudService.getFilteredJobsByLocation(queryString);
		return filteredJobsByLocation;
	}

	

	@GetMapping("/filter-jobs-by-searchtext")
	@ResponseStatus(HttpStatus.OK)
	public List<Job> getFilteredJobsBySearchText(@RequestParam(name = "searchtext") String queryString) {
		List<Job> filteredJobsBySearchText = jobPortalCrudService.getFilteredJobsBySearchText(queryString);
		return filteredJobsBySearchText;
	}
	

	

	

	/*@PutMapping("/user/apply/{jobid}")
    @ResponseStatus(HttpStatus.CREATED)
    public User user(@RequestBody Job user) {
	return jobPortalCrudService.saveAppliedJob(user);}*/

	
}
