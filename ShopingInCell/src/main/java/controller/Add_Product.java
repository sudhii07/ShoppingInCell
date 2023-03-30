package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.productdao;
import dto.Product;
import dto.User;

@WebServlet("/add_product")
public class Add_Product extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	User user = (User) req.getSession().getAttribute("User");
	if (user == null) {
		resp.getWriter().print("<h1><center>Session expired login again</center></h1>");
		req.getRequestDispatcher("login.html").include(req, resp);

	} else {
		Product product=new Product();
		product.setName(req.getParameter("name"));
		product.setPrice(Double.parseDouble(req.getParameter("price")));
		product.setCategory(req.getParameter("category"));
		
		productdao dao=new productdao();
		dao.add_product(product);
		
		resp.getWriter().print("<h1><center>Product added successfully</center></h1>");
		req.getRequestDispatcher("admin_home.html").include(req, resp);
	}
}
}
