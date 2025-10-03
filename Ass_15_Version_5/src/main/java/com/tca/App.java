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
        	
        	Student student = (Student) session.load(Student.class,101);
        	
        	student.setName("Pradeep");
        	student.setPer(91.1);
        	session.update(student);
        	
        	txn.commit();
        	System.out.println("Saved Succesfully !!!");
        	
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
