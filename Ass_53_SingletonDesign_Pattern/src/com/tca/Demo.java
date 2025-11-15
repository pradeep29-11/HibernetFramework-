package com.tca;

class A
{
	private static A ob = null;
	private A()
	{
		System.out.println("Hii");
	}
	public static A getInstance()
	{
		if(ob == null)
		{
			ob = new A();
		}
		return ob;
	}
	
}
//Singleton restrict there should only one object of the class in whole project
//they do not allow to create object with new by user
//We have to call instance method that we have return in that class
public class Demo 
{
	public static void main(String args[])
	{
		A ob1 = A.getInstance();
		A ob2 = A.getInstance();
		
		System.out.println(ob1);
		System.out.println(ob2);
	}
}
