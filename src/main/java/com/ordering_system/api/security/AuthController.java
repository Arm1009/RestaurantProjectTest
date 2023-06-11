package com.ordering_system.api.security;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordering_system.api.security.token.JwtTokenUtils;
import com.ordering_system.api.security.token.RequestDto;

import com.ordering_system.service.impl.UserServiceImpl;

@RestController
public class AuthController {
	
	private final UserServiceImpl userService;
	private final JwtTokenUtils jwtTokenUtils;
	private final AuthenticationManager authenticationManager;
	
	public AuthController(UserServiceImpl userService,JwtTokenUtils jwtTokenUtils, AuthenticationManager authenticationManager) {
		this.userService = userService;
		this.jwtTokenUtils = jwtTokenUtils;
		this.authenticationManager = authenticationManager;
	}
	
	@PostMapping("/auth")
	public String createAuthToken(@RequestBody RequestDto requestDto) {
		UserDetails userDetails = userService.loadUserByUsername(requestDto.getEmail());
		System.out.println(userDetails.getUsername());
		System.out.println(userDetails.getPassword());
		System.out.println(userDetails.getAuthorities());
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDetails.getUsername(),requestDto.getPassword()));
		String token = jwtTokenUtils.generateToken(userDetails);
		return token;
	}
	
}