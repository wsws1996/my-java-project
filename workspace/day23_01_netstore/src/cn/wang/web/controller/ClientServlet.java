package cn.wang.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wang.commons.Page;
import cn.wang.domain.Category;
import cn.wang.service.BussinessService;
import cn.wang.service.impl.BussinessServiceImpl;

public class ClientServlet extends HttpServlet {
	private BussinessService service = new BussinessServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		if ("showIndex".equals(op)) {
			showIndex(request, response);
		} else if ("showCategoryBooks".equals(op)) {
			showCategoryBooks(request, response);
		}
	}

	private void showCategoryBooks(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Category> categories = service.findAllCategories();
		request.setAttribute("cs", categories);
		String num = request.getParameter("num");
		String categoryId = request.getParameter("categoryId");
		Page page = service.findBookPageRecords(num, categoryId);
		page.setUrl("/client/ClientServlet?op=showCategoryBooks&categoryId="
				+ categoryId);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/listBooks.jsp").forward(request,
				response);
	}

	// 展现主页
	private void showIndex(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Category> categories = service.findAllCategories();
		request.setAttribute("cs", categories);
		String num = request.getParameter("num");
		Page page = service.findBookPageRecords(num);
		page.setUrl("/client/ClientServlet?op=showIndex");
		request.setAttribute("page", page);
		request.getRequestDispatcher("/listBooks.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
