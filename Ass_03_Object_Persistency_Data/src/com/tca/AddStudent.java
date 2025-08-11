package com.tca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import com.tca.entities.Student;
import com.tca.util.StudentUtil;

public class AddStudent {

	public static void main(String[] args) 
	{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			
			System.out.print("Enter the Roll No : ");
			int rno = Integer.parseInt(br.readLine());
			
			System.out.print("Enter the Name   : ");
			String name =  br.readLine();
			
			System.out.print("Enter the Per      : ");
			Double per = Double.parseDouble(br.readLine());
			
			Student ob1 = new Student();
			ob1.setRno(rno);
			ob1.setName(name);
			ob1.setPer(per);
			
			
			if(StudentUtil.save(ob1))
			{
				System.out.println("Record is Saved Succesfully for Roll No : "+rno);
			}
			else
			{
				System.out.println("Failed to Save Record for Roll Number : " + rno);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Faild to Save Record !!");
		}
		catch(ClassNotFoundException ae)
		{
			System.out.println("Faild to Load Driver !!");
		}
		catch(Exception e)
		{
			System.out.println("Unknown Problem !!");
		}
		finally
		{
			try 
			{
				br.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
	}

}
