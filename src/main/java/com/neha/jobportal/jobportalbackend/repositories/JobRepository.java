package com.neha.jobportal.jobportalbackend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.neha.jobportal.jobportalbackend.entities.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

	// JPA does not support UNION. Hence Native query
	String findQuery = "SELECT * FROM jobportal.job WHERE title LIKE %?1% UNION SELECT * FROM jobportal.job WHERE description LIKE %?1%";

	@Query(value = findQuery, nativeQuery = true)
	List<Job> findfilteredJobsByQueryString(String queryString);

	String findbyLocationQuery = "SELECT * FROM jobportal.job WHERE location= ?1";

	@Query(value = findbyLocationQuery, nativeQuery = true)
	List<Job> findJobsByLocation(String location);

	/*
	 * String deleteQuery = "DELETE FROM jobs WHERE jobid=$1";
	 * 
	 * @Query(value = deleteQuery, nativeQuery = true) public void deleteById(Long
	 * jobid);
	 */

}