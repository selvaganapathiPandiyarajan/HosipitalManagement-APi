package com.example.user_service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user_service.Dto.AddressDto;
import com.example.user_service.Dto.UserDto;
import com.example.user_service.Service.AddressImp;
import com.example.user_service.Service.UserProfileService;

@RestController
@RequestMapping(value="/api/address")
public class AddressController {

	@Autowired
	private AddressImp addressimp;
	@Autowired
	private UserProfileService userService;
	 


	@GetMapping("/get/{addressId}")
	public ResponseEntity<AddressDto> findById(@PathVariable Integer addressId)
	{
		AddressDto dbUser=addressimp.findById(addressId);
		 return ResponseEntity.ok(dbUser);
		
	}
	@DeleteMapping("/delete/{addressId}")
	public ResponseEntity<Boolean> deletebyId(@PathVariable Integer addressId)
	{
		addressimp.deleteById(addressId);
		return ResponseEntity.ok(true);
	}
	
}
