package cn.wang.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wang.domain.Page;
import cn.wang.service.impl.BussinessService;

public class ListCustomerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5764121403852928367L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String pagenum = request.getParameter("pagenum");
			BussinessService service = new BussinessService();
			String servletName = this.getServletName();
			Page page = service.getPageData(pagenum, request.getContextPath()
					+ "/servlet/" + servletName);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/WEB-INF/jsp/listcustomer.jsp")
					.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "查询失败");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
