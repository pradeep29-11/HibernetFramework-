package com.tca.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student 
{

	@EmbeddedId
	private StudentCompositeKey ob;
	
	@Column(name="city")
	private String city;
	
	public StudentCompositeKey getOb() {
		return ob;
	}
	public void setOb(StudentCompositeKey ob) {
		this.ob = ob;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
