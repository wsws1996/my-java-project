package cn.wang.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wang.domain.Role;
import cn.wang.service.SecurityService;
import cn.wang.utils.WebUtils;

public class AddRoleServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2149631173582991297L;

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
			String name = request.getParameter("name");
			String description = request.getParameter("description");

			Role role = new Role();
			role.setName(name);
			role.setDescription(description);
			role.setId(WebUtils.makeUUID());

			SecurityService service = new SecurityService();
			service.addRole(role);
			request.setAttribute("message", "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "添加失败");
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
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
