package com.assignment.jwtassignment.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.jwtassignment.domain.UserCredential;
import com.assignment.jwtassignment.exception.UserAuthenticationException;
import com.assignment.jwtassignment.service.AuthService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

@RestController
public class AuthController {

	@Autowired
	AuthService authService;
	
	@PostMapping("/token")
	public String token(@RequestBody @Valid UserCredential userCredential) {
		Boolean isAuthenticated = authService.authenticateUser(userCredential);
		
		if(isAuthenticated) {
			Map<String, Object> claims = new HashMap<>();
			claims.put(Claims.ISSUED_AT, new Date());
			Long expirationTime = new Date().getTime() + (24*60*60*1000);
			claims.put(Claims.EXPIRATION, expirationTime);
			claims.put("group", userCredential.getGroup());
			
			String token = Jwts.builder()
				.setClaims(claims)
				.signWith(
						SignatureAlgorithm.HS256,
						"Secret"
					)
				.compact();
			return token;
		} else {
			throw new UserAuthenticationException("User is not authenticated!!");
		}
	}
}
