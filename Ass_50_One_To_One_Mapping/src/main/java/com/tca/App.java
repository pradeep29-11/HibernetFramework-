package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Car;
import com.tca.entities.Engine;

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
        	//Adding car
        	Engine e = new Engine();
        	e.setEid(1234);
        	e.setSize("250 CC");
        	e.setType("Petrol");
        	
        	Car c = new Car();
        	c.setCno("MH162753");
        	c.setCname("SWIFT");
        	c.setE(e);
*/
/*
        	//Adding Engine
        	Car c = new Car();
        	c.setCno("MH23AB1234");
        	c.setCname("Fortuner");
        	
        	
        	
        	Engine e = new Engine();
        	e.setEid(8081);
        	e.setSize("400 CC");
        	e.setType("Petrol");
        	e.setC(c);
        	
        	session.persist(e);
 */
/*
        	//Unique key voilation
        	
        	Engine e = session.get(Engine.class,1234);
        	Car c = new Car();
        	c.setCno("MH12BZ9180");
        	c.setCname("Alto");
        	c.setE(e);
        	session.persist(c);
*/
/*
        	//Fetching records
        	Car c = session.get(Car.class,"MH162753");
        	
        	System.out.println("Car No   : "+c.getCno());
        	System.out.println("Car Name : "+c.getCname());
        	System.out.println("Engine Id: "+c.getE().getEid());
        	System.out.println("Car Type : "+c.getE().getType());
        	System.out.println("Car Size : "+c.getE().getSize());
        	System.out.println("----------------------------------");
*/
        	Engine e = session.get(Engine.class, 1234);
        	System.out.println("Car No   : "+e.getC().getCno());
        	System.out.println("Car Name : "+e.getC().getCname());
        	System.out.println("Engine Id: "+e.getEid());
        	System.out.println("Car Type : "+e.getType());
        	System.out.println("Car Size : "+e.getSize());
        	System.out.println("----------------------------------");
        	
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
