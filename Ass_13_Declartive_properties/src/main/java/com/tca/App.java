package com.tca;

import java.io.FileInputStream;
import java.util.Properties;

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
    		FileInputStream fis = new FileInputStream("src/main/resources/tca.properties");
    		Properties properties = new Properties();
    		properties.load(fis);
    		
    		configuration.setProperties(properties);
    		configuration.addResource("Student.hbm.xml");
    		
    		sf = configuration.buildSessionFactory();
    		session = sf.openSession();
    		txn = session.beginTransaction();
    		
    		Student student = new Student();
    		student.setName("Pradeep");
    		student.setRno(15);
    		student.setPer(90.1);
    		
    		session.save(student);
    		System.out.println("Saved Succesfully !!");
    		
    		txn.commit();
    		
    	}
    	catch(Exception e) 
    	{
    	    if(txn != null) 
    	    {
    	        txn.rollback();
    	    }
    	    e.printStackTrace();
    	}
    	finally
    	{
    		session.close();
    		sf.close();
    	}
    }
}
