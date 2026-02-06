package com.example.user_service.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user_service.Dto.AddressDto;
import com.example.user_service.Dto.UserDto;
import com.example.user_service.Security.JwtUtil;
import com.example.user_service.Service.UserProfileService;
import com.example.user_service.Service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/auth")
public class UserController {
	 
	
	private final PasswordEncoder passwordEncoder;
	private UserProfileService userService;
	
	
	
	public UserController( PasswordEncoder passwordEncoder,
			UserProfileService userService) {
	
		this.passwordEncoder = passwordEncoder;
		this.userService = userService;
	}

	@PostMapping("/register")
	public ResponseEntity<?> save(@RequestBody UserDto userdto)
	{

	    String username = userdto.getCredentialdto().getUsername();

	    Optional<UserDto> existingUser =
	            userService.findByUsername(username);

	    if (existingUser.isPresent()) {
	        return ResponseEntity
	                .badRequest()
	                .body("User already registered");
	    }

	    userdto.getCredentialdto().setPassword(
	            passwordEncoder.encode(
	                    userdto.getCredentialdto().getPassword()
	            )
	    );

	    UserDto dbUser = userService.save(userdto);
		System.out.println(dbUser);
		 return ResponseEntity.status(HttpStatus.CREATED).body(dbUser);
	
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> findById(@PathVariable Integer userId)
	{
		System.out.println("inside userDto ");
		UserDto dbUser=userService.findById(userId);
		 return ResponseEntity.ok(dbUser);
		
	}
	@PutMapping("/edit/{id}")
	public ResponseEntity<UserDto> update(
	        @PathVariable Integer id,
	        @RequestBody UserDto dto) {

	    return ResponseEntity.ok(userService.update(id, dto));
	}

	@GetMapping("/getuser/{username}")
	public ResponseEntity<?> findbyuserName(@PathVariable String username)
	{
		Optional<UserDto> dbUser=userService.findByUsername(username);
		 return ResponseEntity.ok(dbUser);
		
	}
	@GetMapping("/All")
	public ResponseEntity<List<UserDto>> getAll()
	{
		List<UserDto> dbUser=userService.findAll();
		 return ResponseEntity.ok(dbUser);
		
	}
	
	@PutMapping("/{userId}/address")
	public UserDto updateAddress(
	        @PathVariable Integer userId,
	        @RequestBody AddressDto addressDto) {
	    return userService.updateAddress(userId, addressDto);
	}

	@DeleteMapping("/{userId}/deleteaddress/{addressId}")
	public ResponseEntity<?> deleteAddress(
	        @PathVariable Integer userId,
	        @PathVariable Integer addressId) {

	    userService.deleteAddress(userId, addressId);
	    return ResponseEntity.ok("Address deleted successfully");
	}
	
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<Boolean> deletebyId(@PathVariable Integer userId)
	{
		userService.deleteById(userId);
		return ResponseEntity.ok(true);
	}

}
