package com.tca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddStudent {

	public static void main(String[] args) 
	{
		Connection con = null;
		PreparedStatement ps = null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost:3306/hf03";
		final String DB_USER = "root";
		final String DB_PWD = "Root@123";
		
		try 
		{
			//1.Load Driver
			Class.forName(DB_DRIVER);
			
			//2.From Connection
			con = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
			
			//3.Prepare SQl
			
			System.out.print("Enter the Roll No : ");
			int rno = Integer.parseInt(br.readLine());
			
			System.out.print("Enter the Name   : ");
			String name = br.readLine();
			
			System.out.print("Enter the per    : ");
			Double per = Double.parseDouble(br.readLine());
			
			ps = con.prepareStatement("Insert into student values(?,?,?)");
			ps.setInt(1,rno);
			ps.setString(2,name);
			ps.setDouble(3,per);
			
			//4.Fire SQl
			
			int val = ps.executeUpdate();
			
			if(val == 1)
			{
				System.out.println("Record is Inserted Succesfully !!");
			}
			else
			{
				System.out.println("Faild to Save Record !!");
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
