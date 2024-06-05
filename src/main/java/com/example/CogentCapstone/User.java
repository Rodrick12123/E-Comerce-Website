package com.example.CogentCapstone;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	private String password;
	private String role;
	private String email;
	
//	public User(String name, String password, String role, String email) {
//		this.username = name;
//		this.password = password;
//		this.role = role;
//		this.email = email;
//		
//	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getEmail() {
		return this.email;	}
	
	public void setEmail(String email) {
		this.email = email;
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
	
	public void setRole(String role) {
		this.role = role;
	}
	
}
