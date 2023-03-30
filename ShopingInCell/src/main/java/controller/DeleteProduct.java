package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.productdao;
import dto.Product;

@WebServlet("/deleteProduct")
public class DeleteProduct extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	productdao dao=new productdao();
	Product product=dao.fetchproduct(id);
	dao.deleteproduct(product);
	
	req.getRequestDispatcher("view_product").forward(req, resp);
	
}
}
