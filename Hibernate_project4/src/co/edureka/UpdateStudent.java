package co.edureka;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateStudent {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Student st = new Student(106 ,"sammy","sam@yahoo.com","9999999999");
		session.saveOrUpdate(st);
		
		session.getTransaction().commit();
		
		session.close();
		sf.close();
	}

}
