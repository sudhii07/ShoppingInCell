package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.productdao;
import dto.Product;



@WebServlet("/update")
public class Update extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Product product=new Product();
	product.setId(Integer.parseInt(req.getParameter("id")));
	product.setName(req.getParameter("name"));
	product.setCategory(req.getParameter("category"));
	product.setPrice(Double.parseDouble(req.getParameter("price")));
	
	productdao dao=new productdao();
	dao.Update(product);
	req.getRequestDispatcher("admin_home.html").forward(req, resp);
}
}
