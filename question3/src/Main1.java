import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Main1")
public class Main1 extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
  private static final long serialVersionUID = 1L;
  private String head, tail; 
 
  public Main1() {
    super();
    // The following head and tail makes the coding of the dynamic html easier.
  // All you need is to write your message like: head + message + tail.
    head = "<html><title>Not In The List</title><body><font color = blue><h1>";
    tail = "</h1></font></body></html>";
  }     
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) {
	  
    String u = request.getParameter("Aname");
    String p = request.getParameter("Apassword");
    try {
      PrintWriter out = response.getWriter();    
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/test?user=root&password="); 
      String message = "Welcome ";
      
      Statement stmt = con.createStatement();
     String s = "CREATE TABLE IF NOT EXISTS mytable(Username VARCHAR(30), Password VARCHAR(30))";
      stmt.execute(s);

      PreparedStatement pst= con.prepareStatement("select Username, Password from mytable where Username=?");
      pst.setString(1,u);
      
      ResultSet rs=pst.executeQuery();
      
      String pwd = null;
      String user = null;
      
      
      
      
      while(rs.next()){
    	  user = rs.getString("Username");
           pwd=rs.getString("Password");
          
          
         /* if (user == "null" && pwd == "null") 
          {
          String s = "Insert into simple values(\'" + u + "\',\'" + p + "\' )";
          stmt.execute(s);
          out.println("WELCOME  \'" + u + "\'");
          }*/
          if(u.equals(user) && p.equals(pwd)  ){
           
             // out.println(message + " BACK '"+u+"' ");
        	  
        	  message = message + " BACK '"+u+"' ";
      }
          else{
              
             //out.println("Wrong Username and Password");
        	  message =" Wrong Username and Password '"+u+"' " ;
          }
          
         // out.println(   "\'" +user + " " + pwd ); 
          
          
          
          }
      if (user == null && pwd == null) 
      {
      String s1 = "Insert into mytable values(\'" + u + "\',\'" + p + "\' )";
      stmt.execute(s1);
      //out.println( message + u + "\'" +user + " " + pwd );
      message = message + u + "\'" +user + " " + pwd;
      }
      
         
      out.write(head);
      out.write(message );
      out.write(tail);
       
      
      
     
   
      
      
      
      
     // Complete the rest of this class.
     }
    catch( SQLException e )
    {
    e.printStackTrace();	
    	
    } catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch bloc
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   
   
    
  }
}