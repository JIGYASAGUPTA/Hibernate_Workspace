import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;
 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/Main")
public class Main extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
  private static final long serialVersionUID = 1L;
  private String head, tail;
  public Main() {
    super();
    // The following head and tail makes the coding of the dynamic html easier.
  // All you need is to write your message like: head + message + tail.
    head = "<html><title>Not In The List</title><body><font color = blue><h1>";
    tail = "</h1></font></body></html>";
  }    
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    String userName = request.getParameter("Aname");
    String password = request.getParameter("Apassword");
    boolean check = false;
    try {
      PrintWriter out = response.getWriter();   
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=");
      Statement stmt = con.createStatement();
     // stmt.execute("DROP TABLE IF EXISTS mytable");
      String s = "CREATE TABLE IF NOT EXISTS mytable(userName VARCHAR(30), pass VARCHAR(30))";
      stmt.execute(s);
      String sql ;
      ResultSet rs = stmt.executeQuery("Select * from mytable");
      String user;
      String pss;
      while (rs.next())
      {         
                 user = rs.getString(1);
                 pss = rs.getString(2);
                 if(user.equals(userName))
                 {
                                if(pss.equals(password))
                                {
                                             out.println("<html><head></head><body><h1>Welcome back "+user+"</h1></body></html>");   
                                             check = true;
                                               
                                }
                                else
                                {
                                             out.println("<html><body><h1>Please enter correct password "+user+"</h1></body></html>");
                                             check = true;
                                }
                 }
                
        }
      if(check == false){
    	 
      sql = "insert into mytable (userName,pass) values('" + userName + "','" + password + "')";
      stmt.executeUpdate(sql);
      out.println("<html><body><h1>Welcome to the portal "+userName+"</h1></body></html>");
      }
  }
    catch(Exception e){
               System.out.println("Message: " + e.getMessage());
        System.exit(0);
    }
}
}
 
 
/*
 
sql = "select userName from mytable";
stmt.execute(sql);
*/
// Complete the rest of this class.  