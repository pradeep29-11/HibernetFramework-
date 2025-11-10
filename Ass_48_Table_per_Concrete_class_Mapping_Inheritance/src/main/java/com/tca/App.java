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
        	emp.setRno(101);
        	emp.setName("Pradeep");
        	emp.setSalary(2000.12);
        	
        	Executive exe = new Executive();
        	exe.setRno(102);
        	exe.setName("Aniket");
        	exe.setRole("Admin");
        	exe.setBonus(10000.1);
        	
        	session.persist(exe);
        	session.persist(emp);
        	
        	System.out.println("Record is Saved Successfully !!");
        	
        	txn.commit();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        finally
        {
        	sf.close();
        	session.close();
        }
    }
}
