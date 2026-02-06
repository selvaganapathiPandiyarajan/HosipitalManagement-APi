package com.example.user_service.Security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.user_service.Service.UserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class JWTAuthentication extends OncePerRequestFilter {

	private final JwtUtil jwtUtil;
	
	private final UserService userservice;
	
	
	
	
	
	
	
	public JWTAuthentication(JwtUtil jwtUtil, UserService userservice) {
		super();
		this.jwtUtil = jwtUtil;
		this.userservice = userservice;
	}







	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		  String token =request.getHeader("Authorization");
		  if(token != null && token.startsWith("Bearer"))
		  {
			  token =token.substring(7);
			  String username =jwtUtil.extractUsrname(token);
			  if(username != null && SecurityContextHolder.getContext().getAuthentication() == null)
			  {
				  UserDetails userDetails=userservice.loadUserByUsername(username);
				
				  if(jwtUtil.isToken(token))
				  {
					  UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
					  authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				        SecurityContextHolder.getContext().setAuthentication(authToken);
				  
				  }
				  
			  }
			  
			  
		  }
		
		    filterChain.doFilter(request, response);
	}

}
