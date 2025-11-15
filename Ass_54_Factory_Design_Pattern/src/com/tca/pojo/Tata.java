package com.tca.pojo;

public class Tata implements Car
{

	@Override
	public void runing() 
	{
		System.out.println("TATA car is Runnning on MRF Tayers !!");		
	}

	@Override
	public void stop() 
	{
		System.out.println("TATA car Stopped using Air Break !!");		
	}
	
}
