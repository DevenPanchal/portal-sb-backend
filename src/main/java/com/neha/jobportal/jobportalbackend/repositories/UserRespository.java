package com.neha.jobportal.jobportalbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neha.jobportal.jobportalbackend.entities.User;
@Repository
public interface UserRespository extends JpaRepository<User, Long> {

	public User findOneByUsername(String username);
}
