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
    		configuration.configure(); // load & parse XML Files
    		
    		//System.out.println("OBJ :" + configuration);
    		
    		sf = configuration.buildSessionFactory();
    	        		
    		session = sf.openSession();
    		
    		txn = session.beginTransaction();
    	        		
    		Student student = new Student();
    		student.setRno(103);
    		student.setName("BBB");
    		student.setPer(70);
        	
        	session.save(student);
        	
        	txn.commit();  // Whatever DB Operaotion performed should be get persisted permenantly
    		
        	System.out.println("Record is Saved Succesfully !!");
        }
        catch(Exception e)
        {
        	txn.rollback();
        	e.printStackTrace();
        }
        finally
        {
        	if (session != null) 
        	{
       	    session.close();        	
       	    
        	}

        	sf.close();
        }
      
    }
}
