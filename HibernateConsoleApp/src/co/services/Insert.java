package co.services;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.util.HibernateUtil;
import co.model.User;

public class Insert {
	
	public static void main( String[] args){
		
	
		 Session session = HibernateUtil.openSession() ;
		 Transaction tx = session.getTransaction();
		 tx.begin();
		 Hashtable<Integer,String> table  = new Hashtable<Integer , String>();
	
		 System.out.println("Do you wannna insert data");
		 
		 Scanner sc = new Scanner(System.in);

		 String option = "Y";
		 
		 while(  option.equalsIgnoreCase("Y"))
			 {
			 
			 
			 System.out.println("Enter the values");
			 

				Integer mobile = sc.nextInt();
				String name = sc.next();
				
				User user = new User(name, mobile);
				session.saveOrUpdate(user);
				System.out.println("Do you want to save more students [Y/N]");
			
				 Iterator<User> it = session.createQuery("from User").iterate();
				 while(it.hasNext())
				 {
					 
					User u =it.next();
					table.put(u.getMobile(), u.getName());
					
					
					
				 }
				 
				
				option = sc.next();
			 
			 
		     }
		 
		 
	
		 
		 
		 
		 System.out.println("\nEnter your choice : \n1. Search by name\n2. Search by Phone\n3. Exit\nEnteryour choice now: ");
			int choice = 0;
			
			
			
			
			while ( choice != 0)
			{
				switch(choice){
				
				case  1: 
					    System.out.println("Search by a phone number");
				
				         int phn = sc.nextInt();
				
			             String value	=table.get(phn);
			             
			             System.out.println("the value is " + value+ "for the key" + phn);
				        break;
					
				case 2 : System.out.println("Search by a name");
				
				          String name = sc.next();
				          int key=0;
				          
				        /*  for(Entry<Integer, String> entry : table.entrySet())
				          {   //print keys and values
				               System.out.println(entry.getKey() + " : " +entry.getValue());
				          }
*/
				          for(Map.Entry entry: table.entrySet()){
				              if(name.equals(entry.getValue())){
				                  key = (int) entry.getKey();
				                  break; //breaking because its one to one map
				              }
				          }
				          System.out.println("got phnonenumber(key) from name in hashtable key:  "+ key +" name: " +name );

				        
				          
				            break;
				
				
				case 3 : System.out.println("i wanna exit ");
				          choice =0;
				          
				         
				
				
				
				         break;
				
				
				
				
				}
				
				
				
				
				
				
				
			}
			
			
			
		 
			 
			 
		

	}

}
