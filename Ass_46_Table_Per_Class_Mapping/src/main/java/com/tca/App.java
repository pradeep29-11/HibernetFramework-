package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Employee;
import com.tca.entities.Executive;

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
        	
        	Employee ob = new Employee();
        	ob.setId(101);
        	ob.setName("Pradeep");
        	
        	Executive exe = new Executive();
        	exe.setId(102);
        	exe.setName("Aniket");
        	exe.setRole("Admin");
        	
        	session.persist(ob);
        	session.persist(exe);
       
        	txn.commit();
        	
        	System.out.println("Saved Successfully !!");
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
    }
}

/*
  3. Inheritance Mapping
  -> 
 */
