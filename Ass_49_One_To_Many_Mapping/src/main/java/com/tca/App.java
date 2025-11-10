package com.tca;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Department;
import com.tca.entities.Employee;

import jakarta.persistence.FetchType;

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
 			//adding  department
 			///
        	Department d = new Department();
        	d.setDid(102);
        	d.setDname("CS");
        	
        	Employee emp1 = new Employee();
        	emp1.setEid(1);
        	emp1.setEname("Kaushal");
        	emp1.setEsalary(10000.1);
        	emp1.setDept(d);
        
        	Employee emp2 = new Employee();
        	emp2.setEid(2);
        	emp2.setEname("Aditya");
        	emp2.setEsalary(201.1);
        	emp2.setDept(d);;
        	
        	List<Employee> L = Arrays.asList(emp1,emp2);
        	
        	d.setL(L);
        	
        	session.persist(d);
*/ 
        	
/*
        	//Adding employee  
        	
        	Employee emp = new Employee();
        	emp.setEid(3);
        	emp.setEname("Pradeep");
        	emp.setEsalary(2000.1);
        	
        	Department dept = session.get(Department.class,101 );
        	emp.setDept(dept);   	
        	session.update(emp);
        	
        	System.out.println("Record is Saved Successfully !!");;
*/
/*     	//fetch records of department
        	
        	Department dept = session.get(Department.class, 102);
        	
        	System.out.println("Department ID   : "+dept.getDid());
        	System.out.println("Department Name : "+dept.getDname());
        	
        	List<Employee> l = dept.getL();
        	
        	for(Employee e : l)
        	{
        		System.out.println("Employee Id     : "+e.getEid());
        		System.out.println("Employee name   : "+e.getEname());
        		System.out.println("Employee Salary : "+e.getEsalary());
        		System.out.println("-------------------------------------------");
        		
        	}
*/
/*
        	Employee emp = session.get(Employee.class, 1);
        	
        	System.out.println("Employee Id     : "+emp.getEid());
    		System.out.println("Employee name   : "+emp.getEname());
    		System.out.println("Employee Salary : "+emp.getEsalary());
    		
    		//fetch=FetchType.LAZY he property Employee madhi asli tar eka querry fire hoil left join nasli tar 2 queery fire hotil
    		
    		Department dept = emp.getDept();
    		System.out.println("Department ID   : "+dept.getDid());
        	System.out.println("Department Name : "+dept.getDname());
*/
/*
        	//Updating
        	
        	Department dept = session.get(Department.class,102);
        	Employee emp = session.get(Employee.class,3);
        	emp.setDept(dept);
        	
        	session.update(emp);
        	System.out.println("Record is Updated Successfully !!");
*/
        	//Deleting
        	
        	Department dept = session.load(Department.class, 102);
        	
        	session.delete(dept);
        	
        	System.out.println("Record is Deleted Successfullly !!!");
        	txn.commit();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
    }
}
