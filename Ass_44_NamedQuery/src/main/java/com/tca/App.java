package com.tca;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
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
        	
        	/*
        	Query<Student> query = session.createNamedQuery("GET_ALL_INFO",Student.class);
        	List<Student> list = query.list();
        	
        	for(Student S : list)
        	{
        		System.out.println(S.getRno()+"  "+S.getName()+"  "+S.getPer()+"  "+S.getCity());
        	}
        	*/
        	
        	/*
        	Query<Student> query = session.createNamedQuery("GET_CITY_WISE",Student.class);
        	query.setParameter("ncity", "PUNE");
        	List<Student> list = query.list();
        	
        	for(Student S : list)
        	{
        		System.out.println(S.getRno()+"  "+S.getName()+"  "+S.getPer()+"  "+S.getCity());
        	}
        	*/
        	
        	/*
        	MutationQuery query = session.createNamedMutationQuery("MODIFY_STUDENT_CITY");
        	query.setParameter("newCity", "PUNE");
        	query.setParameter("oldCity","PONA");
        	int cnt = query.executeUpdate();
        	
        	System.out.println("Record is Updated succesfully !!! : "+cnt);
        	*/
        	
        	MutationQuery query = session.createNamedMutationQuery("REMOVE_STUDENT");
        	query.setParameter("rollNumber", 109);
        	int cnt = query.executeUpdate();
        	
        	System.out.println("Record is Deleted successfully !! : "+cnt);
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
