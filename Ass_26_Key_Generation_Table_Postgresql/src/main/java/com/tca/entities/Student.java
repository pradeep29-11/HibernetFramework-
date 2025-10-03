package com.tca.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

@Entity
@Table(name="student")
public class Student 
{
	@Id
	@TableGenerator(name="tg",table="mytab",pkColumnName="myid",pkColumnValue="101",valueColumnName="next_hi",initialValue=500,allocationSize=1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tg")
	@Column(name="RNO")
	private Integer rno;

	@Column(name="name")
	private String name;
	
	@Column(name="per")
	private Double per;

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
	
	
}
