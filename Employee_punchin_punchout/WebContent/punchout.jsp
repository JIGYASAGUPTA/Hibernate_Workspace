<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.EmployeeAtt"%>
<%@ page import="com.EmployeeDAO"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

	String id = request.getParameter("email");
String name=(String)session.getAttribute("user");  

  Date date = new Date();

  EmployeeAtt et = new EmployeeAtt(id,date ,false,true);

	EmployeeDAO dao = new EmployeeDAO();
	dao.punchIn(et);
%>
</body>
</html>