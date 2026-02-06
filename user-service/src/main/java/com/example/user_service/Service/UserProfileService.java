package com.example.user_service.Service;

import java.util.List;
import java.util.Optional;

import com.example.user_service.Dto.AddressDto;
import com.example.user_service.Dto.UserDto;

public interface UserProfileService {

	UserDto save(UserDto userdto);
	UserDto findById(Integer userdto);
	List<UserDto> findAll();
	UserDto update(Integer userId,UserDto userdto);
	void deleteById(Integer userId);
	Optional<UserDto> findByUsername(String username);
    void deleteAddress(Integer userId,Integer addressId);
     UserDto updateAddress(Integer userId,AddressDto addressdto);
}
