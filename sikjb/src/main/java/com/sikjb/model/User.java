package com.sikjb.model;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Value;


@Entity
public class User {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(unique=true)
	private String username;
	
	private String password;

	@OneToOne(cascade = {CascadeType.ALL})
	private Role role;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
