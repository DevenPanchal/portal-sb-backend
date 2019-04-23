package com.neha.jobportal.jobportalbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neha.jobportal.jobportalbackend.entities.User;
import com.neha.jobportal.jobportalbackend.repositories.UserRespository;

@Service
public class UserService {
	
	@Autowired
	private UserRespository userRepository;
	
	public User findUserByUsername(String userName) {
		return userRepository.findOneByUsername(userName);
	}
	
	public User save(User user) {
		return userRepository.saveAndFlush(user);
	}

	public User update(User user) {
		return userRepository.save(user);
	}
}