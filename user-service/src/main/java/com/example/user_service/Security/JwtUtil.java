package com.example.user_service.Security;



import java.util.Date;
import java.util.Optional;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.user_service.Repo.CretentialRepo;
import com.example.user_service.Repo.UserRepo;
import com.example.user_service.model.Credential;
import com.example.user_service.model.Role;
import com.example.user_service.model.UserProfile;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	
	
	private static final String SECRET =
	        "T8nMqQZcR9GEdyMfjtvYdiwRHNJRc/82LRM9G9xuvtiMVkShS8Lqy8HWJAeHUl0YEDErfiTiLLKSYT0qIiXFXw==";

	private static final SecretKey secretKey =
	        Keys.hmacShaKeyFor(
	            Decoders.BASE64.decode(SECRET)
	        );
	
	private final int jwtexpireTime =86400000;
	
	@Autowired
	private CretentialRepo cretentialrepo;
	
	  public String generateToken(String username) {
		  System.out.println(
				    Encoders.BASE64.encode(
				        Keys.secretKeyFor(SignatureAlgorithm.HS512).getEncoded()
				    )
				);


	        Credential credential = cretentialrepo.findByUsername(username)
	                .orElseThrow(() -> new RuntimeException("User not found"));

	        String role = credential.getRole().name();

	        return Jwts.builder()
	                .setSubject(username)
	                .claim("role", role)
	                .setIssuedAt(new Date())
	                .setExpiration(new Date(System.currentTimeMillis() + jwtexpireTime ))
	                .signWith(secretKey, SignatureAlgorithm.HS512)
	                .compact();
	    }
	
	  public String extractUsrname(String token)
	  {
		  
		  return  Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().getSubject();
	  }
	  
	 public Role extractRoles(String token)
	 {
		 
		  String role = Jwts.parserBuilder()
		            .setSigningKey(secretKey)
		            .build()
		            .parseClaimsJws(token)
		            .getBody()
		            .get("role", String.class);

		    return Role.valueOf(role);
		 
	 }
	 
	 //Token Validation 
	 
	 public boolean isToken(String token)
	 {  
		 try
		 {
			 Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
		      return true;
		 }catch(JwtException | IllegalArgumentException e)
		 {
			 return false;
		 }
	 }
	 
	 
}
