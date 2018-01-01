package LoginAuth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/CreateController")
public class CreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		out.println("Welcome to Create controller servlet");
		System.out.println(" Welcome To ");
		int type = Integer.parseInt(request.getParameter("type"));

		
		String details = request.getParameter("detail");
		String campus = request.getParameter("campus");
		String location = request.getParameter("location");
		
		
		out.println(type); out.println("<br>");
		
		out.println(details); out.println("<br>");
		
		out.println(campus); out.println("<br>");
		
		out.println(location); out.println("<br>");
		//creating a session
		
		//now creating User object
	NewTicket ticket = new NewTicket( type,  details,  campus, location);
		
		//now we'll call the DAO's method to register the User
		CreateDAO CreateDAO=new CreateDAO();
		int result=CreateDAO.Register(ticket);
		PrintWriter printWriter= response.getWriter();
		if(result!=1)
		{
			
			
			printWriter.println("Congratulations You are successfully created");
			//RequestDispatcher req= request.getRequestDispatcher("MenuServlet");
			//req.forward(request, response);
			
					
		}
		else
		{
			printWriter.println("Problem occured");
		}
		// TODO Auto-generated method stub
		
	}
	


}
