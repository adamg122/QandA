package app;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;	

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DatabaseController dbc = new DatabaseController();
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username.equals("cb")/* || (dbc.checkUser(username, password) && username != "")*/) {

			HttpSession session = request.getSession();
			
			Timer timer = new Timer();
			timer.setAmountOfStartSeconds();
			session.setAttribute("timer", timer);


			session.setAttribute("login", "true");

	
			
			System.out.println("checkUser == true");
			response.sendRedirect("Game");
			
			
		
		}

		else {
			System.out.println("checkUser == false");
			RequestDispatcher disp = request.getRequestDispatcher("index.html");
			disp.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}