package cn.wang.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wang.domain.Customer;
import cn.wang.service.impl.BussinessService;
import cn.wang.utils.WebUtils;

public class AddCustomerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8713669746364382174L;

	/**
	 * 
	 */

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			Customer customer = WebUtils.request2Bean(request, Customer.class);
			customer.setId(WebUtils.makeId());
			BussinessService service = new BussinessService();
			service.addCustomer(customer);
			request.setAttribute("message", "客户添加成功！！！");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "客户添加失败！！！");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
