package assign2Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ser2 extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username= request.getParameter("username");
		String password=request.getParameter("password");
		
		if(username.equals("admin") & password.equals("wipro")) {
			RequestDispatcher rd= request.getRequestDispatcher("success");
			request.setAttribute("loginSuccessful", "Correct password \nlogged in Successfully!");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd= request.getRequestDispatcher("failed");
			request.setAttribute("loginFailed", "Wrong Username or password");
			rd.forward(request, response);
		}
	}
}
