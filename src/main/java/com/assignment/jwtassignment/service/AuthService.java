package com.assignment.jwtassignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.jwtassignment.domain.UserCredential;
import com.assignment.jwtassignment.repository.AuthRepository;

@Service
public class AuthService {

	@Autowired
	private AuthRepository authRepository;
	
	public Boolean authenticateUser(UserCredential userCredential) {
		return authRepository.authenticateUser(userCredential);
	}
}
