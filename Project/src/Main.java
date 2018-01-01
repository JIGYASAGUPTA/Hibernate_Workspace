import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String name,password,register,login,message;

	//A
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		name = request.getParameter("name").trim();
		password = request.getParameter("password").trim();
		register = request.getParameter("register");
		login = request.getParameter("login");
		if(check(name, password)){
			if(login != null)

				processLogin(request,response);
			else
				processRegister(request, response);
		}
		else{
			PrintHtmlString("User ID or Password cannot be null or empty",request,response);	
		}		
	}

	//B. 
	private boolean check(String name, String password){

		//three cases that you return false:
		// name and password are null. or
		// name is not null but it is an empty string. or
		// password is not null but it is an empty string.
		if (name == null){
			return false;
		}
 		else if (name.trim().equals("")){
			return false;
		}	
		else if (password == null){
			return false;
		}
 		else if (password.trim().equals("")){
			return false;
		}
		else{
			return true;
		}
	}

	//C.
	private void processRegister(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//there is no cookie. Make one.
    		// One of cookies’ name is the same as the user name Tell user
    		// you have already registered.
    		//None of the cookies’ name is the same as the user name. Make one

		Cookie[] cookies = request.getCookies();
		
		if (cookies != null && cookies.length > 0)
			for(int i=0; i<cookies.length; i++) {
				Cookie c = cookies[i];

				if (c.getName().trim().equals(name)){ 
					PrintHtmlString("You have already registered",request,response);
					return;
				}
			}

		makeCookie(response);
		PrintHtmlString("You have registerd now",request,response);
		
	}

	//D.
	private void makeCookie(HttpServletResponse response) throws IOException{
		// Make a cookie with its name and value to be the user name and
		// password respectively.
		Cookie aCookie = new Cookie(name.trim(),password);
		aCookie.setMaxAge(60*60*24*365); // duration 1 year
		response.addCookie(aCookie);
	}
	
	//E.
	private void processLogin(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// No cookie at all. Ask the user to register.
    		// No cookie’s name is the same as the user name. Ask the user
    		// to register.
    		// One cookie’s name is the same as the user name. Display
    		// a welcome back message.

		Cookie[] cookies = request.getCookies();
		boolean CookieNameFound=false;
		if (cookies != null && cookies.length > 0){
			for(int i=0; i<cookies.length; i++) {
				Cookie c = cookies[i];

				if (c.getName().trim().equals(name.trim())){
					PrintHtmlString("Welcome Back " + c.getName(),request,response);
					CookieNameFound=true;		
					return;
				}	
							
			}

			if (CookieNameFound==false){
				PrintHtmlString("You have not registered yet, please register first",request,response);	
				return;	
			}
		}
		else{
			PrintHtmlString("You have not registered yet, please register first",request,response);	
			return;	
	
		}
		
	}
	

	private void PrintHtmlString(String msg,HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<form method='get' action='Main'>");
	    	out.println("<center>");
	    	out.println("<br><br>");
		out.println("<strong><span style='color:red;background-color:black;font-size:25px;'>&nbsp;&nbsp;&nbsp;" + msg + "&nbsp;</span></strong><br/><br/>");
	    	out.println("User Name:");
	    	out.println("<input name='name' type='text' value=\"" + name + "\">");
	    	out.println("<br>");
	   	out.println("Password:&nbsp;&nbsp;");
	    	out.println("<input name='password' type='password' value=''>");
	    	out.println("<br><br>");
	    	out.println("<input name='register' type='Submit' value='Register'>");
	    	out.println("<input name='login' type='Submit'    value='  Login  '>");    
	    	out.println("</center>");
		out.println("</form>");

	}

}

