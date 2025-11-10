package com.tca.entities;

import jakarta.persistence.Entity;

@Entity(name="exe2")
public class Executive extends Person
{
	private String role;
	private Double bonus;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Double getBonus() {
		return bonus;
	}
	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}
	
	
	
}
