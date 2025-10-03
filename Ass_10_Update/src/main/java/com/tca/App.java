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
        System.out.println("Hello World!");
        
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
        	
        	Student student = (Student)session.get(Student.class, 101);
        	student.setName("Pradeep jadhav");
        	session.update(student); 
        	
        	System.out.println("Updated Succesfully for Roll Number : "+student.getRno());
        	
        	
        	txn.commit();
        }
        catch(Exception e)
        {
        	txn.rollback();
        	e.printStackTrace();
        }
        finally
        {
        	session.close();
        	sf.close();
        }
    }
}
