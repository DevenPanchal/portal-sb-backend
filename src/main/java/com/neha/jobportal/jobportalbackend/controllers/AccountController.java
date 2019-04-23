package com.neha.jobportal.jobportalbackend.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neha.jobportal.jobportalbackend.entities.User;
import com.neha.jobportal.jobportalbackend.services.UserService;
import com.neha.jobportal.jobportalbackend.utils.CustomErrorType;

@RestController
@CrossOrigin
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private UserService userService;
	// request method to create a new account by Job Seeker
		@CrossOrigin
		@PostMapping(value = "/register")
		public ResponseEntity<?> createUser(@RequestBody User newUser) {
			if (userService.findUserByUsername(newUser.getUsername()) != null) {
				System.out.println("username Already exist " + newUser.getUsername());
				return new ResponseEntity(
						new CustomErrorType("user with username " + newUser.getUsername() + "already exist "),
						HttpStatus.CONFLICT);
			}
			newUser.setRole("Job Seeker");
			
			return new ResponseEntity<User>(userService.save(newUser), HttpStatus.CREATED);
		}
		
		
		// request method to create a new account by a Recruiter
		@CrossOrigin
		@PostMapping(value = "/registerAsRecruiter")
		public ResponseEntity<?> createRecruiter(@RequestBody User newUser) {
			if (userService.findUserByUsername(newUser.getUsername()) != null) {
				System.out.println("username Already exist " + newUser.getUsername());
				return new ResponseEntity(
						new CustomErrorType("user with username " + newUser.getUsername() + "already exist "),
						HttpStatus.CONFLICT);
			}
			newUser.setRole("Recruiter");
			
			return new ResponseEntity<User>(userService.save(newUser), HttpStatus.CREATED);
		}

		// this is the login api/service
		@CrossOrigin
		@RequestMapping("/login")
		public Principal user(Principal principal) {
			System.out.println("user logged "+principal);
			return principal;
		}
}
