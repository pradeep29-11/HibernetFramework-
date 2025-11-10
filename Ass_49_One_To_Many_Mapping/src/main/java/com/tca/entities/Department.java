package com.tca.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name="dept")
public class Department 
{
	@Id
	private Integer did;
	private String dname;
	
	@OneToMany(mappedBy="dept",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	List<Employee> l;

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public List<Employee> getL() {
		return l;
	}

	public void setL(List<Employee> l) {
		this.l = l;
	}
	

}
