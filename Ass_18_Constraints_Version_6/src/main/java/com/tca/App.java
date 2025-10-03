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
        	student.setRno(102);
        	student.setName("Pradeep");
        	student.setPer(90.1);
        	student.setEmail("a@gmail.com");
        	
        	session.persist(student);
        	
        	txn.commit();
        	System.out.println("Saved Succesfully !!");
        }
        catch(Exception e)
        {
        	if (txn != null) 
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
