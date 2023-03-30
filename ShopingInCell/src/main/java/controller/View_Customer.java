package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;

@WebServlet("/view_customer")
public class View_Customer extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("User");
		if (user == null) {
			resp.getWriter().print("<h1><center>Session expired login again</center></h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		} else {

			UserDao dao = new UserDao();
			List<User> list = dao.view_customer();
			
			req.getSession().setAttribute("customerlist", list);
			req.getRequestDispatcher("customer.jsp").include(req, resp);
		}

	}
}
