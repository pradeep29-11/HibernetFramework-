package com.tca;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

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
        	/*
        		--> In Hibernate 5.x+, the SQLQuery Interface is Deprecated,and the method session.createSQLQuery()
        		--> It has been replace with NativeQuery
        	 */
        	/*
        	NativeQuery<Student> query = session.createNativeQuery("select * from student",Student.class);
        	
        	List<Student> l = query.list();
        	
        	for(Student S : l)
        	{
        		System.out.println(S.getRno()+"   "+S.getName()+"  "+S.getPer()+"  "+S.getCity());
        	}
        	*/
        	
        	NativeQuery<Object[]> query = session.createNativeQuery("select srno,sname from student",Object[].class);
        	
        	List<Object[]> l = query.list();
        	
        	for(Object[] ob : l)
        	{
        		for(Object data : ob)
        		{
        			System.out.print(data+"  ");
        		}
        		System.out.println();
        	}
        	
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
