package co.edureka;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
public 	static  SessionFactory getSessionFactory(){
	
	
	Configuration config=null;
	SessionFactory factory=null;
	config=new Configuration();
	 //System.out.println("check here");
	config.configure("hibernate.cfg.xml");
	factory=config.buildSessionFactory();
	return factory;
}

}
