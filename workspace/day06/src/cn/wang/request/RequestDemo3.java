package cn.wang.request;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo3 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RequestDemo3() {
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
		// String value = request.getParameter("name");
		// System.out.println(value);
		// String likes[] = request.getParameterValues("like");
		// for (int i = 0; likes != null && i < likes.length; i++) {
		// String like = likes[i];
		// System.out.println(like);
//		Enumeration enumeration = request.getParameterNames();
//		 while (enumeration.hasMoreElements()) {
//		 String name = (String) enumeration.nextElement();
//		 String value= request.getParameter(name);
//		 System.out.println(name+" = "+value);
//		
//		 }
//		Map<String, String[]> map = request.getParameterMap();
//		for (Map.Entry<String, String[]> me : map.entrySet()) {
//			String name = me.getKey();
//			String[] v = me.getValue();
//			System.out.println(name + " = " + v[0]);
		
//		}
		
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
