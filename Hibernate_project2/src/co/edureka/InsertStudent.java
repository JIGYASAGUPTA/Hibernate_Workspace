package co.edureka;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class InsertStudent {
	
	public static void main( String[] args){
		
		SessionFactory sf = HibernateUtils.getSessionFactory();
		 Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		Scanner sc = new Scanner(System.in);
		
		String req ="Y";
		
		while( req.equalsIgnoreCase("Y"))
		{
		
			System.out.println("Enter the values");
			 
			String id = sc.next();
			Integer Id = Integer.parseInt(id);
			String name = sc.next();
			String email = sc.next();
			String mobile = sc.next();
			Student st = new Student(Id ,name, email , mobile);
			session.save(st);
			System.out.println("Do you want to save more students [Y/N]");
			
			req = sc.next();
			
		}
		
		System.out.println("--------------------------------");
		t.commit();
		session.close();
		sf.close();
		
		
	}
	

}
