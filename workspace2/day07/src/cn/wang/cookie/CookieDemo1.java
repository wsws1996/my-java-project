package cn.wang.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo1 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CookieDemo1() {
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
		response.setContentType("text/html;charset=gb2312");
		PrintWriter printWriter = response.getWriter();
		printWriter.write("这是网站首页！！！<br/>");
		Cookie cookies[] = request.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			if (cookie.getName().equals("lastAccessTime")) {
				Long time = Long.parseLong(cookie.getValue());
				Date date = new Date(time);
				printWriter.write("您上次访问时间是：");
				printWriter.write(date.toLocaleString() + "<br/>");
			}

		}

		Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis()
				+ "");
		cookie.setPath("/day07");
		cookie.setMaxAge(10000);
		response.addCookie(cookie);
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
