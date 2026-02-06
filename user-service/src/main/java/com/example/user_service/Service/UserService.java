package com.example.user_service.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;
import com.example.user_service.Dto.AddressDto;
import com.example.user_service.Dto.UserDto;
import com.example.user_service.Exception.ResourceNotFoundException;
import com.example.user_service.Repo.UserRepo;
import com.example.user_service.helper.AddressHelper;
import com.example.user_service.helper.UserHelper;
import com.example.user_service.model.Address;
import com.example.user_service.model.Credential;
import com.example.user_service.model.UserProfile;

import jakarta.transaction.Transactional;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;




@Service
public class UserService implements UserProfileService,UserDetailsService {

	@Autowired
	private UserRepo userrepo;
    

	
	
	
	
	
	
	@Override
	
	public UserDto save(UserDto userdto) {
		
		UserProfile user = UserHelper.map(userdto);
		UserProfile dbuser= userrepo.save(user);
		 UserDto result = UserHelper.map(dbuser);
		
		 
		 
		// TODO Auto-generated method stub
		return result;
	}

//	@Override
//	public UserDto findById(Integer userId) {
//
//         
//		
//		return userrepo.findById(userId)
//				.map(UserHelper::map)
//				.orElseThrow(()->new ResourceNotFoundException("user not found"));
//	}
	
	
	@Override
    @Cacheable(value = "users", key = "#userId")
	public UserDto findById(Integer userId) {
	    UserDto dbUser = userrepo.findById(userId)
	            .map(UserHelper::map)
	            .orElseThrow(() -> new ResourceNotFoundException("user not found"));

	    return dbUser;
	}

	@Override
	public List<UserDto> findAll() {

	    List<UserProfile> users = userrepo.findAll();

	    List<UserDto> result = new ArrayList<>();
	    for (UserProfile user : users) {
	        result.add(UserHelper.map(user));
	    }

	    return result;
	}

	@Override
	@CacheEvict(
		    value = "users",
		    key = "#userId"
		)
	public UserDto update(Integer userId, UserDto userdto) {

	    UserProfile user = userrepo.findById(userId)
	            .orElseThrow(() -> new RuntimeException("User not found with id " + userId));

	    // 1️⃣ Basic fields
	    user.setFirstName(userdto.getFirstName());
	    user.setLastName(userdto.getLastName());
	    user.setEmail(userdto.getEmail());
	    user.setPhone(userdto.getPhone());
	    user.setBloodGroup(userdto.getBloodGroup());

	    // 2️⃣ Credential
	    if (userdto.getCredentialdto() != null) {
	        Credential credential = user.getCredential();
	        if (credential == null) {
	            credential = new Credential();
	            credential.setUser(user);
	        }

	        BeanUtils.copyProperties(userdto.getCredentialdto(), credential);
	        user.setCredential(credential);
	    }

	    // 3️⃣ Address (OneToMany)
	    if (userdto.getAddress() != null && !userdto.getAddress().isEmpty()) {

	        user.getAddress().clear(); // important for update

	        for (AddressDto dto : userdto.getAddress()) {
	            Address address = new Address();
	            BeanUtils.copyProperties(dto, address);
	            address.setUser(user);
	            user.getAddress().add(address);
	        }
	    }


	    UserDto updated = UserHelper.map(userrepo.save(user));
	    return updated;
	}

	@Transactional
	public UserDto updateAddress(Integer userId, AddressDto addressDto) {

	    UserProfile user = userrepo.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found"));

	    List<Address> addresses = user.getAddress();

	    Address address = addresses.stream()
	            .filter(a -> a.getAddressId().equals(addressDto.getAddressId()))
	            .findFirst()
	            .orElseThrow(() -> new ResourceNotFoundException("Address not found"));

	    address.setFullAddress(addressDto.getFullAddress());
	    address.setCity(addressDto.getCity());
	    address.setPostalCode(addressDto.getPostalCode());
	    address.setCountry(addressDto.getCountry());

	    userrepo.save(user);   // 🔥 cascades to Address

	    return UserHelper.map(user);
	}
	@Transactional
	@Override
	public void deleteAddress(Integer userId, Integer addressId) {

	    UserProfile user = userrepo.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found"));

	    boolean removed = user.getAddress().removeIf(
	            a -> a.getAddressId().equals(addressId)
	    );

	    if (!removed) {
	        throw new ResourceNotFoundException("Address not found");
	    }

	    userrepo.save(user);   // 🔥 orphanRemoval deletes row
	}




	@Override
	@CacheEvict(
		    value = "users",
		    key = "#userId"
		)
	public void deleteById(Integer userId) {

		userrepo.deleteById(userId);
		
	}

	@Override
	public Optional<UserDto> findByUsername(String username) {
		
	    return userrepo.findByCredentialUsername(username)
                .map(UserHelper::map);
		// TODO Auto-generated method stub
	}
	
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	    UserProfile user = userrepo.findByCredentialUsername(username)
	            .orElseThrow(() -> new UsernameNotFoundException("User not found"));

	    Credential credential = user.getCredential();

	    return org.springframework.security.core.userdetails.User
	            .withUsername(credential.getUsername())
	            .password(credential.getPassword())
	            .authorities(credential.getRole().name()) // ✅ ROLE_USER
	            .build();
	}
}



	
	

	

