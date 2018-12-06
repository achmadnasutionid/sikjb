package com.sikjb.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class Role {
	
	@Id
	private Long id;
	
	@Column(name="username", unique=true)
	private String username;
	
	@Column(name="role", unique=true)
	private String role;
	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
 
}
