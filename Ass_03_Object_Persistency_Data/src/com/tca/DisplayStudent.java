package com.tca;

import java.sql.SQLException;
import java.util.List;

import com.tca.entities.Student;
import com.tca.util.StudentUtil;

public class DisplayStudent {

	public static void main(String[] args) 
	{
		try 
		{
			List<Student> L =StudentUtil.fetchAllStudents();
			
			if(L.isEmpty())
			{
				System.out.println("No Record Exist !!");
			}
			else
			{
				for(Student ob : L)
				{
					System.out.println("Name       : "+ob.getName());
					System.out.println("Roll No    : "+ob.getRno());
					System.out.println("Percentage : "+ob.getPer());
					System.out.println("------------------------------");
				} 

			}
		}
		catch(SQLException e)
		{
			System.out.println("Unable to Acceses Data !!");
		}
		catch(ClassNotFoundException ae)
		{
			System.out.println("Unable to Load Driver !!");
		}
		catch(Exception e)
		{
			System.out.println("Unknown Problem !!");
		}
								

	}

}
