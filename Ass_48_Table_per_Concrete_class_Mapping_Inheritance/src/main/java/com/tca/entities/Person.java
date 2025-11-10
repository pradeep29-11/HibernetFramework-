package com.tca.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Person 
{
	@Id
	private Integer rno;
	private String name;
	
	public Integer getRno() {
		return rno;
	}
	public void setRno(Integer rno) {
		this.rno = rno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
