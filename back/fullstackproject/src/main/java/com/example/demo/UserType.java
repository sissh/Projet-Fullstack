package com.example.demo;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usertypes")
public class UserType {    
	@Id	
    @Cascade(CascadeType.ALL)
    String type;
    
    String description;
    
    public String getType() {
    	return type;
    }
    
    public String getDescription() {
    	return description;
    }
    
    public void setType(String argType) {
    	this.type = argType;
    }
    
    public void setDescription(String argDesc) {
    	this.description = argDesc;
    }
}
