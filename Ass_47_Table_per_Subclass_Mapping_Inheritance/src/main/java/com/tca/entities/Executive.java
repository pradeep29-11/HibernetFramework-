package com.tca.entities;

import jakarta.persistence.Entity;

@Entity(name="exe1")
public class Executive extends Employee
{
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
