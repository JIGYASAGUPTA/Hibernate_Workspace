package LoginAuth;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class LoginDAO {
	 static Connection  con = null;

	public static Connection getConnection() throws Exception
	{
		
		Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/incident","root","");
	    return con;
	}
	
	
	
	public  static boolean CheckUser( User user ){
		boolean status = false;
		
		try{
		Connection con=LoginDAO.getConnection();
		  
		  PreparedStatement ps=con.prepareStatement("select name ,password from user where name =? and password = ?");  
		 
		  	ps.setString(1,user.getName());
		    ps.setString(3,user.getPassword()); 
		  	//now we'll insert/update the table user
		  	ResultSet rs=ps.executeQuery();
		  	//status = rs.next();
		  	while(rs.next())
		  	{
		  		status=true;
		  	}
		
	     }
		
		catch(Exception e){
			System.out.println(e);
		}
		return status;
		}

}
