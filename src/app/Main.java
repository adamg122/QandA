package app;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public Main() {
		super();
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {		
		
		
		DatabaseController dbc = new DatabaseController();
		ArrayList<Pytanie> listaPytan = dbc.getListaPytanTest();
		
		request.setAttribute("listaPytan", listaPytan);

		RequestDispatcher disp = request
				.getRequestDispatcher("/WEB-INF/main.jsp");
		disp.forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}