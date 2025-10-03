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
        	System.out.println("hii");
        	configuration.setProperty("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
        	configuration.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/hf03");
        	configuration.setProperty("hibernate.connection.user", "root");
        	configuration.setProperty("hibernate.connection.password","Root@123");
        	
        	configuration.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
        	configuration.setProperty("hibernate.show_sql","true");
        	configuration.setProperty("hibernate.format_sql", "false");
        	configuration.setProperty("hibernate.hbm2ddl.auto","create");
        	configuration.addResource("Student.hbm.xml");

        	
        	
        	sf = configuration.buildSessionFactory();
        	session = sf.openSession();
        	txn = session.beginTransaction();
        	
        	Student student = new Student();
        	student.setRno(101);
        	student.setName("Pradeep");
        	student.setPer(90);
        	session.save(student);
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
