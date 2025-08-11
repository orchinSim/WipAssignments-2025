package assign1Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ser1 extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username=request.getParameter("username");
		String password= request.getParameter("password");
		
		PrintWriter out= response.getWriter();
		out.println("Username= "+ username);
		out.println("Password= "+ password);
		
	}
}
