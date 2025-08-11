package assign2Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFailed extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String failed= (String) request.getAttribute("loginFailed");
		
		PrintWriter out= response.getWriter();
		out.println(failed);
	}

}
