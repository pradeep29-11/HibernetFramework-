package com.tca;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Course;
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
 			//add one course to 2 student
  
        	Course course = new Course();
        	course.setCid(111);
        	course.setCname("Java");
        	
        	Student student1 = new Student();
        	student1.setRno(101);
        	student1.setName("Sumit");
        	student1.setCourses(Arrays.asList(course));
        	
        	Student student2 = new Student();
        	student2.setRno(102);
        	student2.setName("Aniket");
        	student2.setCourses(Arrays.asList(course));
        	session.persist(student1);
        	session.persist(student2);
*/    
/*
        	// Add two course and assign to one Student
        	Course c1 = new Course();
        	c1.setCid(222);
        	c1.setCname("Python");
        	
        	Course c2 = new Course();
        	c2.setCid(333);
        	c2.setCname("Hibernate");
        	
        	Student s = new Student();
        	s.setRno(103);
        	s.setName("Omkar");
        	s.setCourses(Arrays.asList(c1,c2));
        	session.persist(s);
*/
/*
        	//Execting Course is assigning to new Student
        	
        	Course c = session.get(Course.class, 333);
        	Student s = new Student();
        	s.setRno(104);
        	s.setName("Aditya");
        	s.setCourses(Arrays.asList(c));
        	session.persist(s);
*/      
/*
        	//Fetch The Record on the basic of Course
        	//How many student are enrolled in Advanced Java Course
        	
        	Course c = session.get(Course.class, 333);
        	System.out.println("Course ID   : "+c.getCid());
        	System.out.println("Course Name : "+c.getCname());
        	System.out.println("Student Information !!");
        	List<Student> l = c.getStudents();
        	
        	for(Student s : l)
        	{
        		System.out.println("Student Roll No : "+s.getRno());
        		System.out.println("Student Name    : "+s.getName());
        		System.out.println("-----------------------------------------");
        	}
*/
        	//Student 101 How many Course is Enrolled?
        	Student s = session.get(Student.class,101);
        	System.out.println("Student Roll No : "+s.getRno());
    		System.out.println("Student Name    : "+s.getName());
    		
    		List<Course> l = s.getCourses();
    		System.out.println("Courses Information !!");
    		for(Course c : l)
    		{
    			System.out.println("Course ID   : "+c.getCid());
            	System.out.println("Course Name : "+c.getCname());
            	System.out.println("-----------------------------------------");
    		}
        	
        	System.out.println("Work Done !!!");
        	
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
