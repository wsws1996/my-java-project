package cn.wang.servletconfig;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigServletDemo1 extends HttpServlet {

	private ServletConfig config;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String value = null;
		Enumeration enumeration = config.getInitParameterNames();
		while (enumeration.hasMoreElements()) {
			String name = (String) enumeration.nextElement();
			value = config.getInitParameter(name);
			response.getOutputStream().println(name + ":" + value);
		}
		String url=this.config.getInitParameter("url");
		String username=this.config.getInitParameter("username");
		String password=this.config.getInitParameter("password");
		System.out.println(url);
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
	public void init(ServletConfig servletConfig) throws ServletException {
		// Put your code here
		this.config = servletConfig;

	}

}
