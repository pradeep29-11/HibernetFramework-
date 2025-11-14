package com.tca;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tca.entities.Course;
import com.tca.entities.Student;
import com.tca.entities.StudentCourse;

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
        	// I want to assign course-111 to Student-101 
        	Student s = new Student();
        	s.setRno(101);
        	s.setName("Kaushal");
        	
        	Course c = new Course();
        	c.setCid(111);
        	c.setCname("core java");
        	
        	StudentCourse sc = new StudentCourse();
        	sc.setId(1);
        	sc.setCourse(c);
        	sc.setStudent(s);
        	sc.setRegdate(LocalDate.of(2025, 11, 29));
        	
        	session.persist(sc);
*/
/*
        	 // I want to assign Course-222 to Student-101 
        	
        	Student s = session.get(Student.class, 101);
        	Course c = new Course();
        	c.setCid(222);
        	c.setCname("Advance Java");
        	
        	StudentCourse sc = new StudentCourse();
        	sc.setId(2);
        	sc.setCourse(c);
        	sc.setStudent(s);
        	sc.setRegdate(LocalDate.now());
        	
        	session.persist(sc);
*/
/*       	
        	// Student-102 has taken admisson but dont have any course yet.
        	Student s = new Student();
        	s.setRno(102);
        	s.setName("Aniket");
        	
        	session.persist(s);
*/
/*
         	// Launching course-333 Hibernate but not have admission yet
        	
        	Course c = new Course();
        	c.setCid(333);
        	c.setCname("Hibernate");
        	session.persist(c);
*/
/*        	
        	// Student-102 has taken admission for Course-111 Core java 
        	
        	Student s = session.get(Student.class, 102);
        	Course c = session.get(Course.class,111);
        	
        	StudentCourse sc = new StudentCourse();
        	sc.setId(3);
        	sc.setCourse(c);
        	sc.setStudent(s);
        	sc.setRegdate(LocalDate.now());
        	session.persist(sc);
*/        	
/*
          	// Student-103 has taken admission for Course-333 Hibernate
        	
        	Student s = new Student();
        	s.setRno(103);
        	s.setName("Pradeep");
        	
        	//Course c = session.get(Course.class, 333);
        	StudentCourse sc = new StudentCourse();
        	sc.setId(4);
        	sc.setCourse(session.get(Course.class, 333));
        	sc.setStudent(s);
        	sc.setRegdate(LocalDate.now());
        	
        	session.persist(sc);
*/
        	/******************* FETCHING LOGIC *************************/
/*        	
        	// I want see courses joined by Student-101
        	
        	Student s = session.get(Student.class, 101);
        	System.out.println("Student ROll Number : "+s.getRno());
        	System.out.println("Name Of Student     : "+s.getName());
        	
        	List<StudentCourse> l = s.getSc();
        	for(StudentCourse sc : l)
        	{
        		Course c = sc.getCourse();
        		System.out.println("Course ID         : "+c.getCid());
        		System.out.println("Course Name       : "+c.getCname());
        		System.out.println("Registration Date : "+sc.getRegdate());
        		System.out.println("------------------------------------------------");
        		
        	}
*/   
/*        	
        	// I want to list of students who has taken admision for course-111  on which date 
        	
        	Course c = session.get(Course.class,111);
        	System.out.println("Course ID   : "+c.getCid());
        	System.out.println("Course Name : "+c.getCname());
        	
        	List<StudentCourse> l = c.getSc();
        	for(StudentCourse sc : l)
        	{
        		Student s = sc.getStudent();
        		System.out.println("Student Roll Number : "+s.getRno());
        		System.out.println("Student Name        : "+s.getName());
        		System.out.println("Registration Date   : "+sc.getRegdate());
        		System.out.println("-----------------------------------------------");
        	}
*/        	
        	
        	// Find Student-Course Information whose registration take place on  14th Nov, 2025 
    		
        	
        	LocalDate d = LocalDate.of(2025, 11, 14);
    		
    		String hql = "FROM StudentCourse SC WHERE SC.regdate=:udate";
    		
    		Query<StudentCourse> query = session.createQuery(hql, StudentCourse.class);
    		query.setParameter("udate", d);
    		
    		List<StudentCourse> L = query.getResultList();
    		
    		for(StudentCourse SC : L)
    		{
    			Student S = SC.getStudent();
    			Course C = SC.getCourse();
    			
    			System.out.println("Student " + S.getName() +" has registered for " + C.getCname() +" on Date:"+ SC.getRegdate());
    		}
        	
        	System.out.println("Work Done !!");
        	txn.commit();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
    }
}
