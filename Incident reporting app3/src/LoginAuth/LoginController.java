package LoginAuth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		          
		
		String name = request.getParameter("uid");
		String password = request.getParameter("pwd");
		
		User user = new User(name , password);
		LoginDAO loginDAO = new LoginDAO();
	boolean  result = loginDAO.CheckUser(user);
	out.println(result);
	if (result == true)
	{
		out.println("Congratulations You have succesfully login");
		   RequestDispatcher rd=request.getRequestDispatcher("Welcome");  
	        rd.forward(request,response);
		
	}
	
	else{
		
		
		
		out.println(" You have entered wrong userbname and password");
		
		
		
	}
	
	}

	}
