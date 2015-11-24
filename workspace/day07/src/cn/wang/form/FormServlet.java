package cn.wang.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.jms.Message;
import javax.management.RuntimeErrorException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.output.Encoded;

import sun.misc.BASE64Encoder;
import cn.wang.login.User;

public class FormServlet extends HttpServlet {

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
		String token = TokenPriccessor.getInstance().makeToken();
		request.getSession().setAttribute("token", token);
		printWriter.println("<form action='/day07/servlet/DoFormServlet' method='post'>");
		printWriter.write("<input type='hidden' name='token' value='" + token
				+ "'>");
		printWriter.println("用户名：<input type='text' name='username'>");
		printWriter.println("<input type='submit' value='提交'>");
		printWriter.println("</form>");
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

class TokenPriccessor {
	private TokenPriccessor() {
	};

	private static final TokenPriccessor instance = new TokenPriccessor();

	public static TokenPriccessor getInstance() {
		return instance;
	}

	public String makeToken() {
		String token = System.currentTimeMillis()
				+ new Random().nextInt(999999999) + "";
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte md5[] = md.digest(token.getBytes());
			BASE64Encoder base64Encoder = new BASE64Encoder();
			return base64Encoder.encode(md5);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}
