package com.tca.Ass_07_Save_MySql_PostgreSql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) 
    {
    	//PostgsreSql
        Configuration configuration = null;
        SessionFactory sf = null;
        Session session = null;
        Transaction txn = null;
        
        //Mysql
        Configuration configuration2 = null;
        SessionFactory sf2 = null;
        Session session2 = null;
        Transaction txn2 = null;
        try 
        {
            // Load Hibernate Configuration for PostgreSql
            configuration = new Configuration();
            configuration.configure("MySql.cfg.xml");
            //configuration.configure("PostgreSql.cfg.xml");         

            // Build SessionFactory & Open Session
            sf = configuration.buildSessionFactory();
            session = sf.openSession();
            txn = session.beginTransaction();

            // Create Student Object
            Student student = new Student();
            student.setRno(15);
            student.setName("Pradeep");
            student.setPer(1.12);

            // Save Student
            session.save(student);

            // Commit Transaction
            txn.commit();
            
            
            //Load Hibernate Configuration for MySql
            
            configuration2 = new Configuration();
            //configuration2.configure("MySql.cfg.xml");
            configuration2.configure("PostgreSql.cfg.xml");
            
            sf2 = configuration2.buildSessionFactory();
            session2 = sf2.openSession();
            txn2 = session2.beginTransaction();
            
            session2.save(student);
            
            txn2.commit();
            

            System.out.println("Record saved successfully!");
        } 
        catch(Exception e) 
        {

            txn.rollback();
            txn2.rollback();
            e.printStackTrace();
        } 
        finally 
        {
            session.close();
            session2.close();
            
            sf.close();
            sf2.close();
        }
    }
}
