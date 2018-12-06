package com.sikjb.model;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Value;


@Entity
public class User {
	 
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Id
	@Column(unique=true)
	private String username;
	
	private String password;

	@Column(columnDefinition = "Integer DEFAULT 1")
	private Integer enable;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
