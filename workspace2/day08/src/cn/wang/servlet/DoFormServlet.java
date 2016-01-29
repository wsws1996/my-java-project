package cn.wang.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoFormServlet extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean b = isToken(request);
		if (b == true) {
			System.out.println("对不起，请不要重复提交！！！");
			return;
		}
		request.getSession().removeAttribute("token");
		System.out.println("处理中......");
	}

	private boolean isToken(HttpServletRequest request) {
		String client_token = request.getParameter("token");
		System.out.println(client_token);
		if (client_token == null) {
			return true;
		}
		String server_token = (String) request.getSession().getAttribute(
				"token");
		if (server_token == null) {
			return true;
		}
		if (!server_token.equals(client_token)) {
			return true;
		}
		return false;
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
