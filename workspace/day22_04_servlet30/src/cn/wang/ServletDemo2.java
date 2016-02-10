package cn.wang;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/servlet/ServletDemo2", initParams = {
		@WebInitParam(name = "aaa", value = "sss"),
		@WebInitParam(name = "xxx", value = "yyy") })
public class ServletDemo2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6443506460953972294L;

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		String s1 = config.getInitParameter("aaa");
		String s2 = config.getInitParameter("xxx");
		System.out.println(s1);
		System.out.println(s2);
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
