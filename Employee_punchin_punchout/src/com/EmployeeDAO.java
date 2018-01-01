package com;

import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.mapping.List;

import com.Employee;
import com.EmployeeAtt;






public class EmployeeDAO {
	
	
	public  int CheckEmployee(String id,String pas)
	{
		

		Session session = HibernateUtil.openSession();
		Transaction	tx = session.getTransaction();
        tx.begin();
				String hql="From Employee e where e.emailId='"+id+"' and e.passwd='"+pas+"'"; //emaild --->id
		Query query = session.createQuery(hql);
		java.util.List results = query.list();
		
		int count=results.size();
	
		
		
		 
         tx.commit();
         
     return count;
         
         
         
	}
	
	
	public void Addemployee(Employee e)
	{
		
		Session session = HibernateUtil.openSession();
		Transaction trans = null;
		try 
		{
			trans = session.beginTransaction();
			Employee emp = new Employee();
			//since setters and getters are associated, so just create an object and set the name and marks using setters
			emp.setEmailId(e.getEmailId());
			emp.setFname(e.getFname());
			emp.setLname(e.getLname());
			emp.setPasswd(e.getPasswd());
			
			session.persist(emp);
			//session.s
			trans.commit();
			session.clear();
			session.close();
			//session.s
			
			
			//name,mob
			
			//use hashtable to enter the data
			//key=name,val=mobile
			
			
			
			
		} 
		catch (HibernateException ex) {
			if (trans != null) {
				trans.rollback();
				ex.printStackTrace();
			}
		} finally {
			session.close();
		}
	}
	
	

	

	
	public void punchIn(EmployeeAtt et)//emailid, datetime,true=>ppunchin,false=>punchout column
	{
		
		Session session = HibernateUtil.openSession();
		Transaction trans = null;
		try 
		{
			trans = session.beginTransaction();
			EmployeeAtt att = new EmployeeAtt();
			//since setters and getters are associated, so just create an object and set the name and marks using setters
			att.setEmailid(et.getEmailid());
			att.setDate(et.getDate());
			
			
			session.persist(att);
			//session.s
			trans.commit();
			session.clear();
			session.close();
			//session.s
			
			
			//name,mob
			
			//use hashtable to enter the data
			//key=name,val=mobile
			
			
		} 
		catch (HibernateException ex) {
			if (trans != null) {
				trans.rollback();
				ex.printStackTrace();
			}
		} finally {
			session.close();
		}
		
		
		//session.persist(et);
	}
	//
	
	
	
	
	public void punchOut(EmployeeAtt et)//emailid, datetime,true=>ppunchin,false=>punchout column
	{
		
		Session session = HibernateUtil.openSession();
		Transaction trans = null;
		try 
		{
			trans = session.beginTransaction();
			EmployeeAtt att = new EmployeeAtt();
			//since setters and getters are associated, so just create an object and set the name and marks using setters
			att.setEmailid(et.getEmailid());
			att.setDate(et.getDate());
			
			
			session.persist(att);
			//session.s
			trans.commit();
			session.clear();
			session.close();
			//session.s
			
			
			//name,mob
			
			//use hashtable to enter the data
			//key=name,val=mobile
			
			
		} 
		catch (HibernateException ex) {
			if (trans != null) {
				trans.rollback();
				ex.printStackTrace();
			}
		} finally {
			session.close();
		}
		
		
		//session.persist(et);
	}
	//
	
	
	public  java.util.ArrayList getPunchInDate(String email ){
		
		Session session = HibernateUtil.openSession();
		Transaction	tx = session.getTransaction();
        tx.begin();
		
		String hql="From EmployeeAtt e.date  where e.emailid ='"+email+"' and e.punchin=true order by e.date desc limit 1"; //emaild --->id
		Query query = session.createQuery(hql);
		java.util.List results =   query.list();
		    ArrayList<Employee>   arraylist  = (ArrayList)results;
		
		
		//select e.getPunchinDate() from Employeeatt e  where e.emaild ='"+email+"' order by punchindate desc limit 1;
		
		
		return arraylist;
	}
	
	
	
public  java.util.ArrayList getPunchOutDate( String email){
		
	Session session = HibernateUtil.openSession();
	Transaction	tx = session.getTransaction();
    tx.begin();
	
	String hql="'From EmployeeAtt e.Adate  where e.emailId ='"+email+"' and e.punchout=true order by e.Adate desc limit 1'"; //emaild --->id
	Query query = session.createQuery(hql);
	java.util.List results =   query.list();
	
	//select e.getPunchinDate() from Employeeatt e  where e.emaild ='"+email+"' order by punchindate desc limit 1;
	
	
	 ArrayList<Employee>   arraylist  = (ArrayList)results;
		
		
		//
		
		return arraylist;
	
		
	}
	
	
	
	
	//inside JSP pa
	
	
	//
	
	
public   java.util.ArrayList<EmployeeAtt> getAllRecords(String email ){
	Session session = HibernateUtil.openSession();
		
	
	Transaction	tx = session.getTransaction();
    tx.begin();
   
    //java.util.List<EmployeeAtt> results = new ArrayList<EmployeeAtt>();
    
	
	String hql= "From Employee"; //emaild --->id
	Query query = session.createQuery(hql); 
   // java.util.List results = query.list();
     List result = (List) query.list();
     ArrayList<EmployeeAtt> getlist = new ArrayList<EmployeeAtt>();
     
    
	
	Iterator<Employee> itr=((java.util.List) result).iterator();
	 
	
	
	while(itr.hasNext()){
		Employee q=itr.next();
		//System.out.println("Question Name: "+q.getQname());
		
		
		//printing answers
		java.util.List<EmployeeAtt> list2=q.getAttend();
		Iterator<EmployeeAtt> itr2=list2.iterator();
		while(itr2.hasNext()){
		EmployeeAtt att =	itr2.next();
		
		
		getlist.add(att);
		}	
		
		
	

     
	
	   tx.commit();
	   session.close();  
	 
		System.out.println("success");


 	

  	
	
	 
  
	}
	return getlist;

		
		//select e.getPunchinDate() from Employeeatt e  where e.emaild ='"+email+"' order by punchindate desc limit 1;
		

	}
	
	

	

	
}
