package com.example.service.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.service.user.entity.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Long> {

	@Query("SELECT ud FROM UserDetails ud WHERE ud.name=?1")
	List<UserDetails> findUserByName(String name);
	
}
