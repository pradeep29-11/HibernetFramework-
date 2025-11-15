package com.tca.pojo;

public class Mahindra implements Car 
{

	@Override
	public void runing() 
	{
		System.out.println("Mahindra car is Runing On CEAT Tayers !!");
	}

	@Override
	public void stop() 
	{
		System.out.println("Mahindra car is Stopping using Disk Break !!");
	}

}
