package cn.wang.web.UI;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wang.domain.Role;
import cn.wang.domain.User;
import cn.wang.service.SecurityService;

public class AddUserRoleUIServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8588625627042635470L;

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		SecurityService service = new SecurityService();
		User user = service.findUser(user_id);

		List<Role> user_roles = service.getUserRoles(user_id);
		List<Role> system_roles = service.getAllRoles();

		request.setAttribute("user", user);
		request.setAttribute("user_roles", user_roles);
		request.setAttribute("system_roles", system_roles);
		
		request.getRequestDispatcher("/jsp/addUserRole.jsp").forward(request, response);
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
