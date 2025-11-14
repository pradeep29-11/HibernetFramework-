package com.tca.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name="student")
public class Student 
{
	@Id
	private Integer rno;
	private String name;
	
	@OneToMany(mappedBy="student",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<StudentCourse> sc;

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

	public List<StudentCourse> getSc() {
		return sc;
	}

	public void setSc(List<StudentCourse> sc) {
		this.sc = sc;
	}
		
}
