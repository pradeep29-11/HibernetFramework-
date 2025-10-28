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
        Session session =null;
        Transaction txn = null;
        
        try
        {
        	configuration = new Configuration();
        	configuration.configure();
        	
        	sf = configuration.buildSessionFactory();
        	session = sf.openSession();
        	txn = session.beginTransaction();
        	
        	//Query<Object[]> query = session.createQuery("select city,count(*) from Student group by city",Object[].class);
        	
        	//List<Object[]> q = query.getResultList();
        	
			//Query<Student> query = session.createQuery("FROM Student WHERE per BETWEEN 70 AND 80",Student.class);	
        	
        	//Query<Student> query = session.createQuery("FROM Student WHERE city='PUNE' OR city='MUMBAI'",Student.class);
        	
            //Query<Student> query = session.createQuery("FROM Student WHERE city LIKE 'P%' ",Student.class);
        	
           Query<Student> query = session.createQuery("FROM Student WHERE per IS NOT NULL ",Student.class);

			List<Student> L = query.list();

        	for(Student data : L)
        	{
        		System.out.println(data+" ");
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
