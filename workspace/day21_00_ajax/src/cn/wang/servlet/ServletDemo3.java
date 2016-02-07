package cn.wang.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wang.domain.Product;

public class ServletDemo3 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1282337345261628974L;
	/**
	 * Destruction of the servlet. <br>
	 */

	private List<Product> products = new ArrayList<Product>();

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("products", products);
		request.getRequestDispatcher("/listProducts.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		products.add(new Product(1, "洗衣粉", 20));
		products.add(new Product(2, "水浒传", 10));
		products.add(new Product(3, "袜子", 10));
		products.add(new Product(4, "肥皂", 20));
		products.add(new Product(5, "节能灯", 7));
	}

}
