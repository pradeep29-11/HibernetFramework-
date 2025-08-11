package com.tca;

public class Main {

	public static void main(String[] args)
	{
		PojoClass ob = new PojoClass(15,"Pradeep",90.1);
		
		System.out.println("Roll No : "+ob.getRno());
		System.out.println("Name    : " +ob.getName());
		System.out.println("Per     : "+ob.getPer());
		

	}

}
