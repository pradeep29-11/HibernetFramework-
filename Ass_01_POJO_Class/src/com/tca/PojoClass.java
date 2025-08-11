package com.tca;

public class PojoClass 
{
	private int rno;
	private String name;
	private Double per;
	
	public PojoClass(int rno,String name,Double per)
	{
		this.rno=rno;
		this.name=name;
		this.per=per;
	}
	public void setRno(int rno)
	{
		this.rno=rno;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setPer(Double per)
	{
		this.per=per;
	}
	public int getRno()
	{
		return rno;
	}
	public String getName()
	{
		return name;
	}
	public Double getPer()
	{
		return per;
	}
}
