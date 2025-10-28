package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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
        	
        	//Aggregate Function min(),max(),sum(),avg(),count()
        	
        	Query<Long> q1 = session.createQuery("Select count(*) from Student",Long.class);
        	Query<Double> q2 = session.createQuery("Select max(per) from Student",Double.class);
         	
        	Long n = q1.getSingleResult();
        	Double per = q2.getSingleResult();
        	
        	System.out.println("Count of the Student : "+n);
        	System.out.println("Maxmimum Percentage  : "+per);
        	
        	txn.commit();
	
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
