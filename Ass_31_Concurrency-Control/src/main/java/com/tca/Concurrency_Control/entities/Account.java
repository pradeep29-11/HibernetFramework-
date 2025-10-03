package com.tca.Concurrency_Control.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="account")
public class Account 
{
	@Id
	@Column(name="accno")
	private Integer accno;
	
	@Column(name="accholdername")
	private String accholdername;
	
	@Column(name="acctype")
	private String acctype;
	
	@Column(name="amount")
	private Float amount;

	public Integer getAccno() {
		return accno;
	}

	public void setAccno(Integer accno) {
		this.accno = accno;
	}

	public String getAccholdername() {
		return accholdername;
	}

	public void setAccholdername(String accholdername) {
		this.accholdername = accholdername;
	}

	public String getAcctype() {
		return acctype;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}	
}
