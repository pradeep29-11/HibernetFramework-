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
        	
        	Employee emp = new Employee();
        	emp.setId(101);
        	emp.setName("Pradeep");
        	
        	session.persist(emp);
        	
        	Executive exe = new Executive();
        	exe.setId(102);
        	exe.setName("Aniket");
        	exe.setRole("Admin");
        	
        	session.persist(exe);
        	
        	System.out.println("Data is Saved Successfully !!");
        	
        	txn.commit();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
    }
}
