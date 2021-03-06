package cn.wang.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wang.service.impl.BussinessService;

public class DeleteCustomerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4131259690236942120L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			BussinessService service = new BussinessService();
			service.deleteCustomer(id);
			request.setAttribute("message", "删除成功");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "删除失败");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);

		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
