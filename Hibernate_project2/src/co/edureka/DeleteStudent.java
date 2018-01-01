package co.edureka;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteStudent {

	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtils.getSessionFactory();
		 Session session = sf.openSession();
		 session.beginTransaction();
		 
		 Student st = session.get(Student.class , new Integer(234));
		 
		 if( st!= null)
		 {
			 System.out.println(st);
			 session.delete(st);
			 
		 }
		 
		 else
			 System.out.println("No matching student found");
		 session.getTransaction().commit();
		 
		 session.close();
		 sf.close();
		 

	}

}
