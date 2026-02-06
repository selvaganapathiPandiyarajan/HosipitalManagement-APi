package com.example.user_service.helper;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;

import com.example.user_service.Dto.AddressDto;
import com.example.user_service.Dto.CredentialDto;
import com.example.user_service.Dto.UserDto;
import com.example.user_service.model.Address;
import com.example.user_service.model.Credential;
import com.example.user_service.model.UserProfile;

public interface CredentialHelper {
	public static CredentialDto map(Credential credentail) {

		CredentialDto credentialDto =new CredentialDto();
		BeanUtils.copyProperties(credentail, credentialDto);
		
		if(credentail.getUser() != null)
		{
			UserDto userDto =new UserDto();
			BeanUtils.copyProperties(credentail.getUser(),userDto );

			credentialDto.setUserdto(userDto);

		}
					return credentialDto;
	}

	}

