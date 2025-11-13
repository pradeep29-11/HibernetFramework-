package com.tca.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity(name="student")
public class Student 
{
	@Id
	private Integer rno;
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch= FetchType.LAZY)
	@JoinTable(
				name="student_course",
				joinColumns = @JoinColumn(name="FK_RNO"),
				inverseJoinColumns = @JoinColumn(name="FK_CID")		
			)
	private List<Course> courses;

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

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
}
