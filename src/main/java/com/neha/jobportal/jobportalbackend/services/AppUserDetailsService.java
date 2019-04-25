
package com.neha.jobportal.jobportalbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.neha.jobportal.jobportalbackend.entities.User;
import com.neha.jobportal.jobportalbackend.dao.UserRespository;



@Service
public class AppUserDetailsService implements UserDetailsService {

	
	@Autowired
UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.find(username);
		return  user;
	}

}