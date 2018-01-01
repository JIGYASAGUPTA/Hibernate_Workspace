 package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//here we'll get the form's data and then sent that to DAO to process
		
		String email= request.getParameter("email").toString();
		String name = request.getParameter("name").toString();
		//creating a session
		HttpSession session = request.getSession();
		session.setAttribute("name",name);
		session.setAttribute("email",email);
		//now creating User object
		User user = new User(email, name);
		
		//now we'll call the DAO's method to register the User
		RegisterDAO registerDAO=new RegisterDAO();
		int result=registerDAO.registerUser(user);
		PrintWriter printWriter= response.getWriter();
		if(result==1)
		{
			
			
			printWriter.println("Congratulations You are successfully registered");
			RequestDispatcher req= request.getRequestDispatcher("MenuServlet");
			req.forward(request, response);
			
					
		}
		else
		{
			printWriter.println("Problem occured");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
