<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ page import="com.EmployeeDAO"%>
   

   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>loginvalidate</title>
</head>
<body>

<%

String uname = request.getParameter("userid");
String upassword = request.getParameter("password");


session.setAttribute("user",uname);  

//database operation

EmployeeDAO dao = new EmployeeDAO();

  int result = dao.CheckEmployee( uname, upassword);
  
  if (result >= 1)
  {
	  String name=(String)session.getAttribute("user");  
		 response.sendRedirect("EmployeePortal.jsp");
	
	  
	  
  }


  else
  {
	  
	  response.sendRedirect("logout.jsp");
	  
	  
	  
	  
  }









%>

</body>
</html>