package com.tca;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tca.entities.Student;

public class App 
{
    public static void main(String[] args) 
    {
       Configuration configuration = null;
       SessionFactory sf = null;
       Session session = null;
       Transaction txn = null;
       
       try
       {
    	   configuration = new Configuration();
    	   configuration.configure();
    	   
    	   sf = configuration.buildSessionFactory();
    	   session = sf.openSession();
    	   txn = session.beginTransaction();
    	   
    	   Query query = session.createQuery("From Student");
    	   List<Student> list = query.list();
    	   
    	   for(Student ob : list)
    	   {
    		   System.out.println("Roll Number : "+ob.getRno());
    		   System.out.println("Name        : "+ob.getName());
    		   System.out.println("Percentage  : "+ob.getPer());
    		   System.out.println("-------------------------------");
    	   } 
       }
       catch(Exception e)
       {
    	   e.printStackTrace();
       }
       finally
       {
    	   session.close();
    	   sf.close();
       }
    }
}
