package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
    		
    		Student student = new Student();
    		student.setRno(16);
    		student.setName("Pradeep");
    		student.setPer(80.2);
    		
    		//session.save(student);
    		
    		session.persist(student);
    		txn.commit();		// Whatever DB Operation performed should be get persisted permenantly
    		
    		System.out.println("Record is Save succesfully !!!");
    	}
    	catch(Exception e)
    	{
    		txn.rollback();
    		e.printStackTrace();
    	}
    	finally
    	{
    		session.close();
    		sf.close();
    	}
    }
    
}
