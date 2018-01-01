package co.edureka;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SearchStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		
		/*Student st = new Student();
		//session.load(st, new Integer(234));
		 * 
		 System.out.println(st);
		 */
		
		
		Student st = session.get(Student.class, new Integer(234));
		if (st!=null)
		System.out.println(st);	
		else
		System.out.println("No matching student found !!");	
		
		session.close();
		sf.close();

	}

}
