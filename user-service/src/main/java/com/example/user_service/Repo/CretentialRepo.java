package com.example.user_service.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.user_service.model.Credential;

@Repository
public interface CretentialRepo extends JpaRepository<Credential, Integer> {

	Optional<Credential> findByUsernameAndPassword(String username, String password);
	Optional<Credential> findByUsername(String username);

}
