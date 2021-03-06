package cn.wang.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wang.domain.User;
import cn.wang.service.BusinessService;
import cn.wang.service.impl.BusinessServiceImpl;

public class LoginServlet extends HttpServlet {

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
		BusinessService businessService = new BusinessServiceImpl();
		User user = businessService.loginUser(username, password);
		if (user == null) {
			request.setAttribute("message", "对不起，用户名和/或密码有误");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}
		request.getSession().setAttribute("user", user);
		request.setAttribute(
				"message",
				"恭喜您："
						+ user.getUsername()
						+ "，登录成功！本页面将在5秒后跳到首页！！！<meta http-equiv='refresh' content=5;url=/day09_user/index.jsp");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
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
