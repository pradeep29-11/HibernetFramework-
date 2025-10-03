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
        	configuration.addAnnotatedClass(Student.class);
        	sf = configuration.buildSessionFactory();
        	session = sf.openSession();
        	txn = session.beginTransaction();
        	
        	
        	Student student = new Student();
        	
        	student.setRno(15);
        	student.setName("pradeep");
        	student.setPer(90.0);
        	
        	session.persist(student);
        	System.out.println("Saved Succesfully !!");
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
