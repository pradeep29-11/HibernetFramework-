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
        SessionFactory sf = null;
        Session session = null;
        Transaction txn = null;

        try 
        {
            // Load configuration & build SessionFactory
            sf = new Configuration().configure().buildSessionFactory();

            // Open session
            session = sf.openSession();

            // Start transaction
            txn = session.beginTransaction();

            // Create student object
            Student student = new Student();
            student.setRno(101);
            student.setName("BBB");
            student.setPer(70);

            // Save student record
            session.save(student);

            // Commit transaction
            txn.commit();

            System.out.println("Record saved successfully!");
        } 
        catch (Exception e) 
        {
            // Rollback only if transaction is active
            if (txn != null && txn.isActive()) 
            {
                txn.rollback();
            }
            e.printStackTrace();
        } 
        finally 
        {
            // Close session
            if (session != null && session.isOpen()) 
            {
                session.close();
            }
            // Close SessionFactory
            if (sf != null && !sf.isClosed()) 
            {
                sf.close();
            }
        }
    }
}