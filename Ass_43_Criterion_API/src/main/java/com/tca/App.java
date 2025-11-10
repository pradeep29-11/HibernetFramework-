package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.tca.entities.Student;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.Root;

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
    	  
    	  //Select * from student
    	  /*
    	  CriteriaBuilder cb = session.getCriteriaBuilder();
    	  
    	  CriteriaQuery<Student> cq = cb.createQuery(Student.class);
    	  Root<Student> root = cq.from(Student.class);
    	  cq.select(root);
    	  
    	  Query<Student> query = session.createQuery(cq);
    	  List<Student> l = query.list();
    	  
    	  for(Student S : l)
    	  {
    		  System.out.println(S.getRno()+" "+S.getName()+"  "+S.getPer()+"  "+S.getCity());
    	  }
    	  */
    	  
    	  //Select * from student order by per desc
    	  /*
    	  CriteriaBuilder cb = session.getCriteriaBuilder();
    	  CriteriaQuery<Student> cq = cb.createQuery(Student.class);
    	  Root<Student> root = cq.from(Student.class);
    	  cq.select(root).orderBy(cb.desc(root.get("per")));
    	  
    	  List<Student> l = session.createQuery(cq)
    			  				.list();
    	  
    	  for(Student S : l)
    	  {
    		  System.out.println(S.getRno()+" "+S.getName()+"  "+S.getPer()+"  "+S.getCity());
    	  }
     	  */
    	  
    	  //select * from student where per>=70 and per<=90
    	  /*
    	  CriteriaBuilder cb = session.getCriteriaBuilder();
    	  CriteriaQuery<Student> cq = cb.createQuery(Student.class);
    	  Root<Student> root = cq.from(Student.class);
    	  
    	  Predicate p1 = cb.greaterThanOrEqualTo(root.get("per"), 70);
    	  Predicate p2 = cb.lessThanOrEqualTo(root.get("per"), 90);    	  
    	  cq.select(root).where(cb.and(p1,p2));
    	  
    	  List<Student> l = session.createQuery(cq)
    			  				.list();
    	  
    	  for(Student S : l)
    	  {
    		  System.out.println(S.getRno()+" "+S.getName()+"  "+S.getPer()+"  "+S.getCity());
    	  }
    	  */
    	  
    	  //Specific Column - Select name,city,per from student;
    	  //Tuple (stud_name:AAA,city:PUNE,per:70)
    	  /*
    	  CriteriaBuilder cb = session.getCriteriaBuilder();
    	  CriteriaQuery<Tuple> cq = cb.createTupleQuery();
    	  Root<Student> root = cq.from(Student.class);
    	  
    	  cq.multiselect(root.get("name").alias("name"),root.get("city").alias("city"),root.get("per").alias("per"));
    	  Query<Tuple> query = session.createQuery(cq);
    	  List<Tuple> result = query.list();
    	  
    	  for(Tuple t : result)
    	  {
    		  System.out.println(t.get("name")+"  "+t.get("city")+"  "+t.get("per"));
    	  }
    	  */
    	  
    	  //Select * from student where city like 'P%';
    	  /*
    	  CriteriaBuilder cb = session.getCriteriaBuilder();
    	  CriteriaQuery<Student> cq = cb.createQuery(Student.class);
    	  Root<Student> root = cq.from(Student.class);
    	  cq.select(root).where(cb.like(root.get("city"), "P%"));
    	  
    	  List<Student> l =  session.createQuery(cq)
    	  							.list();
    	  
    	  for(Student ob : l)
    	  {
    		  System.out.println(ob.getRno()+"  "+ob.getName()+"  "+ob.getPer()+"  "+ob.getCity());
    	  }
    	  */
    	  
    	// Select max(per) from student;
    	  /*
    	  CriteriaBuilder cb = session.getCriteriaBuilder();
    	  CriteriaQuery<Double> cq = cb.createQuery(Double.class);
    	  Root<Student> root = cq.from(Student.class);
    	  cq.select(cb.max(root.get("per")));
    	  
    	  Double ans = session.createQuery(cq)
    			  			.getSingleResult();
    	  
    	  System.out.println("Maximun Percentage : "+ans);
    	  */
    	  
    	// Select city, count() from student group by city having count()>=2;
    	 /* 
    	  CriteriaBuilder cb = session.getCriteriaBuilder();
    	  CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
    	  Root<Student> root = cq.from(Student.class);
    	  
    	  Expression<Long> exp = cb.count(root);
    	  
    	  cq.multiselect(root.get("city"),exp);
    	  cq.groupBy(root.get("city"));
    	  cq.having(cb.gt(exp, 1));
    	  
    	  Query<Object[]> query = session.createQuery(cq);
    	  
    	  List<Object[]> l = query.list();
    	  
    	  for(Object[] row : l)
    	  {
    		System.out.println(row[0]+"--->"+row[1]);  
    	  }
    	  
    	  */
    	  
    	  //Update student set per=90.1 where rno=101;
    	  /*
    	  CriteriaBuilder cb = session.getCriteriaBuilder();
    	  CriteriaUpdate<Student> cu = cb.createCriteriaUpdate(Student.class);
    	  Root<Student> root = cu.from(Student.class);
    	  cu.set("per",80.25);
    	  cu.where(cb.equal(root.get("rno"),101));
    	  
    	  MutationQuery query = session.createMutationQuery(cu);
    	  int cnt = query.executeUpdate();
    	  
    	  System.out.println("Records is Updated Successfully !! : "+cnt);
    	  */
    	  
    	  //Delete from student where rno=110;
    	  
    	  CriteriaBuilder cb = session.getCriteriaBuilder();
    	  CriteriaDelete<Student> cd = cb.createCriteriaDelete(Student.class);
    	  Root<Student> root = cd.from(Student.class);
    	  
    	  cd.where(cb.equal(root.get("rno"), 110));
    	  
    	 MutationQuery query = session.createMutationQuery(cd);
    	 
    	 int cnt = query.executeUpdate();
    	 
    	 System.out.println("Record is Deleted Successfully !! : "+cnt);
    	 
    	  
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
