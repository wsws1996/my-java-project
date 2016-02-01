package cn.wang.web.UI;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wang.domain.Privilege;
import cn.wang.domain.Role;
import cn.wang.service.SecurityService;

public class AddRolePrivilegeUIServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8300044236341967445L;

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String role_id = request.getParameter("role_id");
		SecurityService service = new SecurityService();
		Role role = service.findRole(role_id);
		List<Privilege> role_privileges = service.getRolePrivileges(role_id);
		List<Privilege> system_privileges = service.getAllPrivilege();

		request.setAttribute("role", role);
		request.setAttribute("role_privileges", role_privileges);
		request.setAttribute("system_privileges", system_privileges);

		request.getRequestDispatcher("/jsp/addRolePrivilege.jsp").forward(
				request, response);
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
