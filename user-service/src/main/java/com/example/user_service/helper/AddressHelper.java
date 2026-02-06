package com.example.user_service.helper;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;

import com.example.user_service.Dto.AddressDto;
import com.example.user_service.Dto.UserDto;
import com.example.user_service.model.Address;
import com.example.user_service.model.UserProfile;

public interface AddressHelper {

	
	
	public static AddressDto map(Address address) {
	    if (address == null) return null;

	    AddressDto addressDto = new AddressDto();
	    BeanUtils.copyProperties(address, addressDto);

		 if (address.getUser() != null) {
		        UserDto userDto = new UserDto();
		        userDto.setUserId(address.getUser().getUserId());
		        userDto.setFirstName(address.getUser().getFirstName());
		        userDto.setEmail(address.getUser().getEmail());

		        addressDto.setUserdto(userDto);
		    }
	    // ❌ DO NOT map user
	    // ❌ NO UserDto here
	    
	    
		

	    return addressDto;
	}
	public static Address map(AddressDto addressDto) {
	    if (addressDto == null) return null;

	    
	    
	    Address address = new Address();
	    BeanUtils.copyProperties(addressDto, address);
        UserProfile user=new UserProfile();
	    // ❌ DO NOT map user
	    // ❌ NO UserDto here
	    
	    address.setUser(user);
	    // ❌ DO NOT create UserProfile here
	    // User relationship must be set by the parent mapper (UserHelper)

	    return address;
	}

}
