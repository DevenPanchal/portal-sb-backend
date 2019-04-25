package com.neha.jobportal.jobportalbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neha.jobportal.jobportalbackend.entities.User;
import com.neha.jobportal.jobportalbackend.dao.UserRespository;

@Service
public class UserService {
	
	@Autowired
	UserRespository userRepository;
	
	public User find(String userName) {
		return userRepository.findOneByUsername(userName);
	}
	
	public User save(User user) {
		return userRepository.saveAndFlush(user);
	}

	public User update(User user) {
		return userRepository.save(user);
	}
	
	

}