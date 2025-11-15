package com.tca;

import com.tca.factory.CarFactory;
import com.tca.pojo.Car;

public class Demo 
{

	public static void main(String[] args) 
	{
		//Tata t = new Tata();
		//Mahindra m = new Mahindra(); 
		
		//Tata t = new Mahindra();
				
		Car t = CarFactory.getCar();
		t.runing();
		t.stop();
		

	}

}
