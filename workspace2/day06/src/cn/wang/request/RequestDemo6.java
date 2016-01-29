package cn.wang.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo6 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RequestDemo6() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("iso8859-1");
		String username = request.getParameter("username");
		// byte source[]= username.getBytes("UTF-8");
		// username= new String(source,"UTF-8");
		System.out.println(username);
		String name = request.getParameter("name");
		System.out.println("name = " + name);
		// response.setCharacterEncoding("UTF-8");
		// response.setContentType("text/html;charset=UTF-8");
		// response.getWriter().write(username);
		// System.out.println(username);
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
