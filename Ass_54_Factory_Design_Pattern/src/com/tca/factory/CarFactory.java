package com.tca.factory;

import com.tca.pojo.Car;
import com.tca.pojo.Mahindra;

public class CarFactory 
{
	private static Car ob = null;
	
	public static Car getCar()
	{
		if(ob == null)
		{
			//ob = new Tata();
			ob = new Mahindra();
		}
		return ob;
	}
}
