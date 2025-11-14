package com.tca.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Course 
{
	@Id
	private Integer cid;
	private String cname;
	
	@OneToMany(mappedBy="course",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<StudentCourse> sc;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public List<StudentCourse> getSc() {
		return sc;
	}

	public void setSc(List<StudentCourse> sc) {
		this.sc = sc;
	}
	
	
}
