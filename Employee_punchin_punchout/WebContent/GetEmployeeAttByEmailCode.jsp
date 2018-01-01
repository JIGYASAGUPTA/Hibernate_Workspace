<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
 <%@page import="java.util.*"%>  
<%@ page import="com.EmployeeAtt"%>
<%@ page import="com.EmployeeDAO"%>
<%@ page import="com.Employee"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String email = request.getParameter("Email");

EmployeeDAO dao = new EmployeeDAO();
java.util.List <EmployeeAtt> list =   dao.getAllRecords(email);

//iterate through each of the list and display the value

for (EmployeeAtt e :list)
{
	
out.println(" date is	"+e.getDate()+"");
out.println("Emailid is	"+e.getEmailid()+"");
out.println	("punchnin is"+e.isPunchin()+"");
out.println	("punchpout is"+e.isPunchout()+"");
	

}



	

	
%>

</body>
</html>