package LoginAuth;

import java.sql.*;


public class CreateDAO {

	 static Connection  con = null;

	public static Connection getConnection() throws Exception
	{
		
		Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/incident","root","");
	    return con;
	}
	public int Register( NewTicket ticket ){
		System.out.println(ticket.getType());
		
		
		int res=0;
		try{
		Connection con=CreateDAO.getConnection();
		  PreparedStatement ps=con.prepareStatement("insert into reportsystem(TYPE, DETAIL, CAMPUS, LOCATION) values (?,?,?,?)");  
		  ps.setInt(1,ticket.getType());
		     ps.setString(2,ticket.getDetails());  
			ps.setString(3,ticket.getCampus());
			ps.setString(4,ticket.getLocation());
		  
		  
		  
		  
		  	  
			
			System.out.println();
		  	
		  	//now we'll insert/update the table user
		  	res=ps.executeUpdate();
		  	if(res>0)
		  	{
		  		System.out.println("Record inserted");
		  	}
		}
		catch(Exception e)
		{
			System.out.println("Some exception in the sqlor connection");
			e.printStackTrace();
		}

		return res;
		
		
		
		
		
		
	}
	
	
	

}
