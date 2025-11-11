package com.tca.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Engine 
{
	@Id
	private Integer eid;
	private String size;
	private String type;
	
	@OneToOne(mappedBy="e",cascade = CascadeType.ALL)
	Car c;

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Car getC() {
		return c;
	}

	public void setC(Car c) {
		this.c = c;
	}
	
	
}
