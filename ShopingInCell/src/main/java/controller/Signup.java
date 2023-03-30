package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;

@WebServlet("/signup")
public class Signup extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user=new User();
		user.setEmail(req.getParameter("email"));
		user.setMobile(Long.parseLong(req.getParameter("mobile")));
		user.setName(req.getParameter("name"));
		user.setPassword(req.getParameter("password"));
		user.setRole(req.getParameter("role"));
		
		UserDao dao=new UserDao();
		try {
			dao.addUser(user);
			
			resp.getWriter().print("<h1>Account created successfully</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		
		} catch (Exception e) {
			resp.getWriter().print("<h1>Account already exists,longin here");
			req.getRequestDispatcher("login.html").include(req, resp);
		}
	}		 
}
