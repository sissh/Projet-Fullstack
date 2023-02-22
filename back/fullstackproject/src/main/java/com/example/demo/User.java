package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userType")
	UserType userType;
    
	String name;
	String firstName;
	String email;
	
	public Integer getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public UserType getUserType() {
		return this.userType;
	}
	
	
	public void setId(Integer argId) {
		this.id = argId;
	}
	
	public void setName(String argName) {
		this.name = argName;
	}
	
	public void setFirstName(String argFirstName) {
		this.firstName = argFirstName;
	}
	
	public void setEmail(String argEmail) {
		this.email = argEmail;
	}
	
	public void setUserType(UserType argType) {
		this.userType = argType;
	}
}
