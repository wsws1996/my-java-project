package cn.wang.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wang.domain.User;
import cn.wang.service.BussinessService;
import cn.wang.service.impl.BussinessServiceImpl;

public class PrivilegeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8705301843070022751L;
	private BussinessService service = new BussinessServiceImpl();

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = service.login(username, password);
		if (user == null) {
			response.getWriter().write("用户名或密码错误，2秒后转向登录页面");
			response.setHeader("Refresh", "2;URL=" + request.getContextPath()
					+ "/passport/adminlogin.jsp");
			return;
		}
		request.getSession().setAttribute("user", user);
		response.sendRedirect(request.getContextPath()+"/manage/index.jsp");
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
