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
        	
        	//Integer rno=104;
        	//Query<Student> query = session.createQuery("from Student where rno=?1");
        	
        	//query.setParameter(1,rno);
        	
        	Integer mixPer = 50;
        	Integer maxPer = 90;
        	
        	Query<Student> query = session.createQuery("from Student where per>=?1 and per<=?2",Student.class);
        	
        	query.setParameter(1, mixPer);
        	query.setParameter(2, maxPer);
        	List<Student> L = query.list();
        	
        	for(Student s : L)
        	{
        		System.out.println("Roll Number : " + s.getRno());
    			System.out.println("Name        : " + s.getName());
    			System.out.println("Percentage  : " + s.getPer());
    			System.out.println("City        : " + s.getCity());
    			System.out.println("-----------------------------------------");

        	}
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
