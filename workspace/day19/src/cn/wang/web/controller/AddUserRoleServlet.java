package cn.wang.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wang.service.SecurityService;

public class AddUserRoleServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5261081980419125101L;

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String user_id = request.getParameter("user_id");
			String role_ids[] = request.getParameterValues("role_id");
			SecurityService service = new SecurityService();
			service.updateUserRole(user_id, role_ids);
			request.setAttribute("message", "授予角色成功");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "授予角色失败");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
