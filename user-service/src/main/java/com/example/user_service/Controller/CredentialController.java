package com.example.user_service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user_service.Dto.CredentialDto;
import com.example.user_service.Security.JwtUtil;
import com.example.user_service.Service.CredentialImp;
import com.example.user_service.model.Role;


@RestController
@RequestMapping("/api")
public class CredentialController {

	@Autowired
	private CredentialImp credentailImp;
	private AuthenticationManager authenticationManager;
	private JwtUtil jwtutil;
	
	@Value("${role.admin}")
	private String roleAdmin;
	@Value("${role.user}")
	private String roleUser;
	@Value("${role.doctor}")
	private String roleDoctor;
	
	public CredentialController( AuthenticationManager authenticationManager,
			JwtUtil jwtutil) {
		super();
		this.authenticationManager = authenticationManager;
		this.jwtutil = jwtutil;
	}



	@GetMapping("/login/{username}/{password}")
	public ResponseEntity<CredentialDto> credentailImpfindusernameAndPassowrd(@PathVariable String username,@PathVariable String password)
	{
		System.out.println(username);
		
		CredentialDto result= credentailImp.findByUserNameAndPassword(username, password);
		
		return ResponseEntity.ok(result);
	}
	
	
	@GetMapping("/loginData")
	public ResponseEntity<String> getData(
	        @RequestHeader("Authorization") String token) {

	    if (token == null || !token.startsWith("Bearer ")) {
	        return ResponseEntity
	                .status(HttpStatus.UNAUTHORIZED)
	                .body("Missing or invalid Authorization header");
	    }

	    String jwtToken = token.substring(7);

	    try {
	        if (!jwtutil.isToken(jwtToken)) {
	            return ResponseEntity
	                    .status(HttpStatus.FORBIDDEN)
	                    .body("Invalid token");
	        }

	        String username = jwtutil.extractUsrname(jwtToken);
	        Role role = jwtutil.extractRoles(jwtToken); // SINGLE role

	        switch (role) {
	            case ROLE_USER:
	                return ResponseEntity.ok(
	                        "Welcome Patient " + username + " | Role: " + role);

	            case ROLE_ADMIN:
	                return ResponseEntity.ok(
	                        "Welcome Admin " + username + " | Role: " + role);

	            case ROLE_DOCTOR:
	                return ResponseEntity.ok(
	                        "Welcome Doctor " + username + " | Role: " + role);

	            default:
	                return ResponseEntity
	                        .status(HttpStatus.FORBIDDEN)
	                        .body("No access");
	        }

	    } catch (Exception e) {
	        return ResponseEntity
	                .status(HttpStatus.FORBIDDEN)
	                .body("Invalid token");
	    }
	}
	
	
	
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody CredentialDto credential)
	{
		try
		{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credential.getUsername(),credential.getPassword()));
		}catch(Exception e)
		{
			System.out.println("Exception:"+e);
		}
		
		String token =jwtutil.generateToken(credential.getUsername());
		return ResponseEntity.ok(token);
		
	}
	
	
}
