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
    	  
    	  /*
    	  Integer rno = 101;    			  
    	  Query<Student> query = session.createQuery("From Student where rno=:srno",Student.class);    	  
    	  query.setParameter("srno",rno);
    	  */
    	  
    	  Integer minPer = 70;
    	  Integer maxPer = 100;
    	  Query<Student> query = session.createQuery("From Student where per>=:minPer and per<=:maxPer");
    	  
    	  query.setParameter("minPer",minPer);
    	  query.setParameter("maxPer", maxPer);
    	  List<Student> l = query.list();
    	  
    	  
    	  for(Student ob : l)
    	  {
    		  System.out.println("Name       : "+ob.getName());
    		  System.out.println("Percentage : "+ob.getPer());
    		  System.out.println("City       : "+ob.getCity());
    		  System.out.println("-------------------------------------");
    	  }
    	  
    	  txn.commit();
       }
       catch(Exception e)
       {
    	   e.printStackTrace();       
       }
    }
}
