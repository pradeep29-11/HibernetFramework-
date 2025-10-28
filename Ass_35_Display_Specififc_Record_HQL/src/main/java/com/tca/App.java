package com.tca;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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
    	    * Display Specific Records
    	    * 
    	   Query query = session.createQuery("Select name,rno from Student");
    	   
    	   List<Object[]> list = query.getResultList();
    	   */
    	   
    	   //Display Per+5 Column Extra
    	   
    	   Query<Object[]> query = session.createQuery("select name,rno,per,per+5 from Student",Object[].class);
    	   
    	   List<Object[]> list = query.getResultList();
    	   
    	   for(Object[] ob : list)
    	   {
    		   for(Object data : ob)
    		   {
    			   System.out.println(data+" ");
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
