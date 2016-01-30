package cn.wang.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wang.dao.UserDao;
import cn.wang.domain.User;
import cn.wang.utils.WebUtils;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2649865066502915519L;

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDao dao = new UserDao();
		User user = dao.find(username, password);
		if (user == null) {
			request.setAttribute("message", "用户名或密码错误");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
		} else {
			request.getSession().setAttribute("user", user);
			request.setAttribute("message", "恭喜您，登录成功");
			sendAutoLoginCookie(request, response, user);
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
		}

	}

	private void sendAutoLoginCookie(HttpServletRequest request,
			HttpServletResponse response, User user) {
		int logintime = Integer.parseInt(request.getParameter("logintime"));
		Cookie cookie = new Cookie("autologin", user.getUsername() + "."
				+ WebUtils.md5(user.getPassword()));
		cookie.setMaxAge(logintime);
		cookie.setPath("/day18");
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
