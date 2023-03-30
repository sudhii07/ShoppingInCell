package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.User;

@WebServlet("/sessionvalidation")
public class SessionValidation extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user=(User) req.getSession().getAttribute("User");
		if(user==null) {
			resp.getWriter().print("<h1><center>Session expired login again</center></h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		} 
		else{
			req.getRequestDispatcher("add_product.html").forward(req, resp);
			
		}
	}

}
