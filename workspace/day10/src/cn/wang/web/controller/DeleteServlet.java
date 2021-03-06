package cn.wang.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wang.domain.Cart;
import cn.wang.exception.CartNotFoundException;
import cn.wang.service.BusinessService;

public class DeleteServlet extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookid = request.getParameter("bookid");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		BusinessService service = new BusinessService();
		try {
			service.deleteBook(bookid, cart);
			request.getRequestDispatcher("/WEB-INF/jsp/listcart.jsp").forward(
					request, response);
		} catch (CartNotFoundException e) {
			// TODO: handle exception
			request.setAttribute("message", "对不起，您还没有购买任何商品！！！");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
		}
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
		// Put your code here
	}

}
