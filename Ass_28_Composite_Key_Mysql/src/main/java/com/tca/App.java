package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Student;
import com.tca.entities.StudentCompositeKey;

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
        	
        	StudentCompositeKey ob = new StudentCompositeKey();
        	ob.setFname("Pradeep");
        	ob.setLname("Jadhav");
        	
        	Student student = new Student();
        	student.setOb(ob);
        	student.setCity("Pune");
        	
        	session.persist(student);
        	
        	System.out.println("Record is Saved Succesfully !!");
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
