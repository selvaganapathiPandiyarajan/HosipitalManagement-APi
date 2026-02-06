package com.example.user_service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.user_service.model.UserProfile;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserProfile, Integer> {

	Optional<UserProfile> findByCredentialUsername(String username);
	
	

	}

