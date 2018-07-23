package com.assignment.jwtassignment.repository;

import org.springframework.stereotype.Repository;

import com.assignment.jwtassignment.domain.UserCredential;

@Repository
public class AuthRepository {

	
	public Boolean authenticateUser(UserCredential userCredential) {
		//Authenticate user against database values
		String userName= userCredential.getUserName();
		String password = userCredential.getPassword();
		return userName.equals(password);
	}
}
