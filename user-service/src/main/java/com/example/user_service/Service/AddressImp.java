package com.example.user_service.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user_service.Dto.AddressDto;
import com.example.user_service.Dto.UserDto;
import com.example.user_service.Repo.AddressRepo;
import com.example.user_service.helper.AddressHelper;
import com.example.user_service.helper.UserHelper;
import com.example.user_service.model.Address;
import com.example.user_service.model.UserProfile;

@Service
public class AddressImp implements AddressService {

	@Autowired
	private AddressRepo addressrepo;
	
	@Override
	public AddressDto save(AddressDto addressdto) {
		
		Address address = AddressHelper.map(addressdto);
		Address dbuser= addressrepo.save(address);
		AddressDto result = AddressHelper.map(dbuser);
		
		// TODO Auto-generated method stub
		return result;
		
	}

	@Override
	public AddressDto findById(Integer addressId) {

		return addressrepo.findById(addressId)
				.map(AddressHelper::map)
				.orElseThrow(()->new RuntimeException("user not found"));

	}

	@Override
	public AddressDto update(Integer addressId, AddressDto addressdto) {

		return null;
	}

	@Override
	public void deleteById(Integer addressId) {

		addressrepo.deleteById(addressId);

	}

}
