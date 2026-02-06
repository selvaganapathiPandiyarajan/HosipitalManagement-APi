package com.example.user_service.Service;

import com.example.user_service.Dto.AddressDto;
import com.example.user_service.Dto.UserDto;

public interface AddressService {

	AddressDto save(AddressDto addressdto);
	AddressDto findById(Integer addressId);
	AddressDto update(Integer addressId,AddressDto addressdto);
	void deleteById(Integer addressId);
	
	
}
