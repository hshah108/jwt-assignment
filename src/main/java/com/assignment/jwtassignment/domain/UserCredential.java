package com.assignment.jwtassignment.domain;

import javax.validation.constraints.NotNull;

public class UserCredential {

	@NotNull
	String userName;
	
	@NotNull
	String password;
	
	@NotNull
	String group;

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
