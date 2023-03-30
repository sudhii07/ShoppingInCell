package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.productdao;
import dto.Product;

@WebServlet("/placeorder")
public class PlaceOrder extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		productdao dao = new productdao();
		List<Product> products = new ArrayList<>();
		for (char i = 'a'; i <= 'z'; i++) {
			String a = req.getParameter(i + "");
			if (a != null) {
				int id = Integer.parseInt(a);
				Product product = dao.fetchproduct(id);
				products.add(product);
			} else {
				continue;
			}

		}
		if(products!=null) {
			req.getSession().setAttribute("products", products);
			req.getRequestDispatcher("bill.jsp").forward(req, resp);
		} else {
			resp.getWriter().print("Please select any one of them");
		}

	}
}
