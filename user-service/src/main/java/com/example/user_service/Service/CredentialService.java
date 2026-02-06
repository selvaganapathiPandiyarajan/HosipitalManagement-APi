package com.example.user_service.Service;

import java.util.Optional;

import com.example.user_service.Dto.CredentialDto;

public interface CredentialService {

	CredentialDto findByUserNameAndPassword(String username ,String password);

	
}
