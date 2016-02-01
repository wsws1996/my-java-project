package cn.wang.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wang.domain.Privilege;
import cn.wang.service.SecurityService;
import cn.wang.utils.WebUtils;

public class AddPrivilegeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7031439619357618231L;

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

			Privilege privilege = new Privilege();
			privilege.setName(name);
			privilege.setDescription(description);
			privilege.setId(WebUtils.makeUUID());

			SecurityService service = new SecurityService();
			service.addPrivilege(privilege);

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
