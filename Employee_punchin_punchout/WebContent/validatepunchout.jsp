<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>validatepuchout</title>
</head>
<body>
String name=(String)session.getAttribute("user"); 
String email = request.getParameter("email");
String punchin = request.getParameter("OUT");
Date date1 = new Date();

EmployeeDAO emp = new EmployeeDAO();
ArrayList<EmployeeAtt> result = new ArrayList<EmployeeAtt>();

result = emp.getPunchOutDate(email);

System.out.println(result);

for (EmployeeAtt res : result)
{
	System.out.println(res.getDate());
	
     date1 = res.getDate();
}

 

SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 Date date = new Date();
	format1.format(date);
	
	
	if (  date == date1)
	{
		System.out.println("You hsave already punched out");
		
	}
	
	else
	{
		
		 response.sendRedirect("punchout.jsp");
		
		
	}	






</body>
</html>