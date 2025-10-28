package com.tca.entities;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")

//@FilterDef(name="cityfilter", parameters = @ParamDef(name="tca",type=String.class))
//@Filter(name="cityfilter", condition = "city = :tca")

//@FilterDef(name="perfilter", parameters = @ParamDef(name="pers",type=Double.class))
//@Filter(name="perfilter",condition="sper >= :pers")

@FilterDefs(
		{
			@FilterDef(name="cityfilter", parameters= @ParamDef(name="tca",type=String.class)),
			@FilterDef(name="perfilter", parameters=@ParamDef(name="pers",type=Double.class))			
		}
			)

@Filters(
		{
			@Filter(name="cityfilter",condition="city=:tca"),
			@Filter(name="perfilter",condition="sper >= :pers")
		}
		)

public class Student 
{
	@Id
	@Column(name="srno")
	private Integer rno;
	
	@Column(name="sname")
	private String name;
	
	@Column(name="sper")
	private Double per;
	
	@Column(name="city")
	private String city;

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
}
