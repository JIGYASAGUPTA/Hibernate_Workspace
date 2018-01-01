package com.servlets;
//this calss will take care of the DB operations// modell
import java.sql.*;
public class RegisterDAO 
{
	public static Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/edureka","root","");
	    return con;
	}
	public int registerUser(User user)
	//public int registerUser(String emai,String anme)
	{
		int res=0;
		try{
		Connection con=RegisterDAO.getConnection();
		  PreparedStatement ps=con.prepareStatement("insert into user(email,name) values (?,?)");  
		  	ps.setString(1,user.getEmail());  
		  	ps.setString(2,user.getName());  
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
		}

		return res;
	}
}
