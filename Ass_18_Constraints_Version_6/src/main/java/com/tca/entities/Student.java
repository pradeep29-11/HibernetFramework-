package com.tca.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tca_student")
public class Student 
{
	@Id
	@Column(name="tca_rno")
	private Integer rno;
	
	@Column(name="tca_name" , length=50 , nullable=false)
	private String name;
	
	@Column(name="tca_per" , columnDefinition="float CHECK(tca_per>=0 and tca_per<=100)")
	private Double per;
	
	@Column(name="tca_email" , length=20 , unique=true , nullable=false)
	private String email;
	
	public Integer getRno() 
	{
		return rno;
	}
	public void setRno(Integer rno) 
	{
		this.rno = rno;
	}
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public Double getPer() 
	{
		return per;
	}
	public void setPer(Double per) 
	{
		this.per = per;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
}
