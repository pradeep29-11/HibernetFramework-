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
        Session session1 = null;
        Session session2 = null;
        Transaction txn = null;
        
        try
        {
        	configuration = new Configuration();
        	configuration.configure();
        	sf = configuration.buildSessionFactory();
        	session1 = sf.openSession();
        	session2 = sf.openSession();
        	txn = session1.beginTransaction();
        	/*
        	 * Same reference of two object
        	 * Only one chache memory will be created beacuse of one session object
        	 * 
        	Student std = new Student();
        	std.setRno(101);
        	std.setName("Aniket");
        	std.setPer(80.12F);
        	
        	session.persist(std);
        	
        	Student s1 = session.load(Student.class, 101);
        	System.out.println(std);
        	System.out.println(s1);
        	
        	*/
        	
        	//different refernce of  object
        	//Two chache memory will be created beacyse of two session object
        	
        	
        	
        	txn.commit();
        	System.out.println("Done !!");
        	
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
        	session1.close();
        	session2.close();
        	sf.close();
        }
    }
}
