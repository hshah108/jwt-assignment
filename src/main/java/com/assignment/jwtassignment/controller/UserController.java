package com.assignment.jwtassignment.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@RestController
public class UserController {

	@GetMapping(value="/admin")
	public boolean admin(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");
		String token = authHeader.split(" ")[1];
		final Claims claims = Jwts.parser()
				.setSigningKey("Secret")
				.requireExpiration(new Date(new Date().getTime()+(24*60*60*1000)))
				.parseClaimsJws(token).getBody();
		String group = (String)claims.get("group");
		if(group.equals("admin")) {
			return true;
		}
		return false;
	}
}
