import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestClass {

	public static void main(String[] args) {
		
		
		Session session		= CartHome.getsessionfactory().openSession();
		Transaction tx = session.getTransaction();
		 tx.begin();
		 
		
		 CartId cart = new CartId("abc" , "abas" ,34.45);
		 Cart c   = new Cart(cart);
		 
		 CartHome obj = new CartHome();
		 
		 obj.attachClean(c);
		 
		 System.out.println(obj.findById(c.getId()));
		
		System.out.println("inserted");
			//sf.close();
		
	}

}
