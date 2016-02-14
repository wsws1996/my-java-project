package cn.wang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletDemo1 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2309219184814970055L;

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String ftoken = request.getParameter("token");
		HttpSession session = request.getSession();
		String stoken = (String) session.getAttribute("token");

		if (ftoken.equals(stoken)) {
			String name = request.getParameter("name");
			System.out.println(name);
			session.removeAttribute("token");
		}else {
			response.getWriter().write("请不要重复提交");
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
		// Put your code here
	}

}
