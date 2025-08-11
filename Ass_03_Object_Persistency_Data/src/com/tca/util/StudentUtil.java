package com.tca.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tca.entities.Student;

public class StudentUtil {

	public static boolean save(Student ob) throws SQLException,ClassNotFoundException
	{
		final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost:3306/hf03";
		final String DB_USER = "root";
		final String DB_PWD = "Root@123";
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try 
		{
			Class.forName(DB_DRIVER);
			
			con = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
			
			ps = con.prepareStatement("Insert into student values(?,?,?)"); 
		
			ps.setInt(1,ob.getRno());
			ps.setString(2,ob.getName());
			ps.setDouble(3,ob.getPer());
			
			int val = ps.executeUpdate();
			
			if(val == 1)
			{
				//System.out.println("Record is Inserted Succesfully !! ");
				return true;
			}
		}
		finally
		{
			con.close();
		}
		return false;

	}	
	public static List<Student> fetchAllStudents() throws SQLException,ClassNotFoundException
	{
		List<Student> L = new ArrayList<>();
		
		final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost:3306/hf03";
		final String DB_USER = "root";
		final String DB_PWD = "Root@123";
		
		ResultSet rs = null;
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try
		{
			Class.forName(DB_DRIVER);
			
			con = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
			
			ps = con.prepareStatement("Select * from student");
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				int rno = rs.getInt(1);
				String name = rs.getString(2);
				Double per = rs.getDouble(3);
				
				Student s = new Student();
				
				s.setRno(rno);
				s.setName(name);
				s.setPer(per);
				
				L.add(s);
				
			}
		}
		finally
		{
			con.close();
		}
		
		
		return L;
	}
	
	
}







