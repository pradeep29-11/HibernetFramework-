package com.tca.entities;

import jakarta.persistence.Entity;

@Entity(name="emp2")
public class Employee extends Person
{
	private Double salary;

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	
}
