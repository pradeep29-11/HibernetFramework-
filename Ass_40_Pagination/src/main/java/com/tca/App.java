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
        	
        	Query<Student> query = session.createQuery("From Student",Student.class);
        	query.setMaxResults(3);
        	
        	for(int i=0;i<10;i=i+3)
        	{
        		query.setFirstResult(i);
        		List<Student> L = query.list();	
        		
        		for(Student ob : L)
        		{
        			System.out.println("Roll Number : " + ob.getRno());
        			System.out.println("Name        : " + ob.getName());
        			System.out.println("Percentage  : " + ob.getPer());
        			System.out.println("City        : " + ob.getCity());
        			System.out.println("-----------------------------------------");

        		}
        		System.out.println("Press Any key to Coninue.....");
    			System.in.read();
        	}
        	
        	txn.commit();
        	
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
    }
}
