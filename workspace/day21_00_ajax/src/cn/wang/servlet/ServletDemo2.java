package cn.wang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5651682192180275327L;
	/**
	 * Destruction of the servlet. <br>
	 */

	private String usernames[] = { "admin", "111111" };

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");//该方法接受的编码方式为application/x-www-form-urlencoded
		boolean b = false;
		for (String string : usernames) {
			if (string.equals(username)) {
				b = true;
				break;
			}
		}
		response.setContentType("text/html;charset=UTF-8");
		if (b) {
			response.getWriter().write("<font color='red'>用户名不可用</font>");
		} else {
			response.getWriter().write("<font color='green'>用户名可用</font>");
		}
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

	}

}
