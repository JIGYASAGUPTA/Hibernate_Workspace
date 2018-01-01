<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="com.EmployeeAtt"%>
<%@ page import="com.EmployeeDAO"%>
<%@page import="java.util.Date"%>

<%@ page import="javax.servlet.http.HttpServletRequest" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Punchin</title>
</head>
<body>

<%

	String id = request.getParameter("email");
String name=(String)session.getAttribute("user");  

  SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
   Date date = new Date();
	format1.format(date);
	
  EmployeeAtt at = new EmployeeAtt(id,date ,true,false);

	EmployeeDAO dao = new EmployeeDAO();
	dao.punchIn(at);
	
	

%>
