package com.example.user_service.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.user_service.Dto.CredentialDto;
import com.example.user_service.Repo.CretentialRepo;
import com.example.user_service.helper.CredentialHelper;
import com.example.user_service.model.Credential;

@Service
public class CredentialImp implements CredentialService {

	@Autowired
	private CretentialRepo cretentialrepo;
	
	@Override
	public CredentialDto findByUserNameAndPassword(String username, String password) {
		
		// TODO Auto-generated method stub
		
		
		Optional<Credential> Data= cretentialrepo.findByUsernameAndPassword(username, password);
		
		if(Data.isPresent())
		{
			Credential dbObj=Data.get();
			return CredentialHelper.map(dbObj);
		}
		else
		{
			throw new RuntimeException("User Not found");
		}
	}
}

	

