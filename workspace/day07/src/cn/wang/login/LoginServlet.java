package cn.wang.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = DB.find(username, password);
		if (user == null) {
			printWriter.write("用户名或密码有误！！");
			return;
		}
		request.getSession().setAttribute("user", user);
		response.sendRedirect("/day07/index.jsp");
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

class DB {
	private static List<User> list = new ArrayList<User>();
	static {
		list.add(new User("aaa", "123"));
		list.add(new User("bbb", "123"));
		list.add(new User("ccc", "123"));
	}

	public static User find(String username, String password) {
		for (User user : list) {
			if (user.getUsername().equals(username)
					&& user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
}

