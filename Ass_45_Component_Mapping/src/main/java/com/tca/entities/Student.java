package com.tca.entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="student")

public class Student 
{
	@Id
	private Integer rno;
	private String name;
	private Double per;
	
	@Embedded
	Address address;

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

	public Double getPer() {
		return per;
	}

	public void setPer(Double per) {
		this.per = per;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
}
