package com.example.CogentCapstone;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class User {
	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String username;
	private String password;
	private String role;
	
	public void User(String name, String password, String role) {
		this.username = name;
		this.password = password;
		this.role = role;
	}
	
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String pass) {
		
		this.password = pass;
	}

	public String getRole() {
		return this.role;
	}
	
}
