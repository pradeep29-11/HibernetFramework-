package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Address;
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
        	
        	Address address = new Address();
        	address.setCity("Beed");
        	address.setState("Maharashtra");
        	address.setCountry("India");
        	
        	Student ob = new Student();
        	ob.setRno(101);
        	ob.setName("Pradeep");
        	ob.setPer(90.12);
        	ob.setAddress(address);
        	
        	session.persist(ob);
        	
        	System.out.println("Saved Successfully !!!");
        	
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

/*
 	Mapping : 
 				Hibernate Mapping refers java class and feilds maps to the database cha Column and Table sobat.
 				
  :-- There are 4 types of mapping 
   1. Basic Mapping
   2. Component Mapping
   3.Inheritance Mapping
   4.Association Mapping (like One-to-One Mapping,One-to-Many Mapping, etc)
   
   1.Basic Mapping
   --> basic mapping manche apan data feild cha type apan hibernate madhi deto pn tevch database madhi change asto tayla basic mapping mantcha.
    	example : string in the hibernate is varchar in the database.
    	

  2.Component Mapping 

+-----+---------+-------+------+-------------+---------+
| rno | name    | per   | city | state       | country |
+-----+---------+-------+------+-------------+---------+
| 101 | Pradeep | 90.12 | Beed | Maharashtra | India   |
+-----+---------+-------+------+-------------+---------+


	1.eka class madhi dusre class cha object data member manun  thevlo jato tayla component mapping mantcha.
	2.dusre class cha feild logical releted astecha.
	3.pahile class object save karto tevha 2ni class data member cha feilds column manun save hoteta ekcha table madhi.
	4.chache memory madhi pahile class objct madhi dusre class cha reference save hoto ani taya comom feild ahe tycha ekcha object asto.

 */
