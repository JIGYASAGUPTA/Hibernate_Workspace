
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EmployeePortal</title>
</head>








<body>
<form action="validatepunchin.jsp" method="post">
<table>
<tr><td>EmailId</td><td><input type="text" name="email"/></td></tr>

<tr><td colspan="2"><input type="submit" name="IN" value="punchin"/></td></tr>
</table>
</form>


<form action="validatepunchout.jsp" method="post">
<table>
<tr><td>EmailId</td><td><input type="text" name="Employeename"/></td></tr>

<tr><td colspan="2"><input type="submit" name="OUT" value="punchout"/></td></tr>
</table>
</form>

<form method="post" action="GetEmployeeAttByEmailCode">
<input type="text" name="Email">
<input type="submit" value="Get Attenence">
</form>



</body>
</html>