package com.assignment.jwtassignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserAuthenticationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserAuthenticationException(String error) {
		super(error);
	}
}
