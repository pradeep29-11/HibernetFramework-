package com.tca.Concurrency_Control;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.Concurrency_Control.entities.Account;

public class App 
{
    public static void main(String[] args) 
    {
       Configuration configuration = null;
       SessionFactory sf = null;
       Session session = null;
       Transaction txn = null;
       
       Integer senderAccNo = 101;
       Integer receiverAccNo = 102;
       Float amount = 500.0F;
       try
       {
    	   configuration = new Configuration();
    	   configuration.configure();
    	   sf = configuration.buildSessionFactory();
    	   session = sf.openSession();
    	   
    	   Account senderOb = session.get(Account.class,senderAccNo,LockMode.PESSIMISTIC_WRITE);
    	   
    	   if(senderOb == null)
    	   {
    		   System.out.println("Invalid Sender's Account Number : "+senderAccNo);
    		   return;
    	   }
    	   
    	   Account receiverOb = session.get(Account.class,receiverAccNo,LockMode.PESSIMISTIC_WRITE);
    	   
    	   if(receiverOb == null)
    	   {
    		   System.out.println("Invalid Receiver Account Number : "+receiverAccNo);
    		   return;
    	   }
    	   txn = session.beginTransaction();
    	   
    	   System.out.println("Press Any key... ");
   		   System.in.read();

    	   
    	   senderOb.setAmount(senderOb.getAmount()-amount);
    	   
    	   receiverOb.setAmount(receiverOb.getAmount()+amount);
    	   
    	   txn.commit();
    	   
    	   System.out.println("Amount is Transfered Succesfully !!!");
   		   System.out.println("Press Any key to exit... ");
   		   System.in.read();

    	   
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
