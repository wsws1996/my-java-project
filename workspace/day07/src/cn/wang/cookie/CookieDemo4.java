package cn.wang.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo4 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CookieDemo4() {
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
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
		String id = request.getParameter("id");
		Book book = DB.getAll().get(id);
		printWriter.write("您要查看的书的详细信息如下：<br/><br/>");
		printWriter.write(book.getId() + "<br/>");
		printWriter.write(book.getName() + "<br/>");
		printWriter.write(book.getAuthor() + "<br/>");
		printWriter.write(book.getDescription() + "<br/>");

		String bookHistory = makeHistory(request, id);
		Cookie cookie = new Cookie("bookHistory", bookHistory);
		cookie.setMaxAge(1*30*24*3600);
		response.addCookie(cookie);
	}

	private String makeHistory(HttpServletRequest request, String id) {
		// TODO Auto-generated method stub

		String bookHistory = null;
		Cookie cookies[] = request.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if (cookies[i].getName().equals("bookHistory")) {
				bookHistory= cookies[i].getValue();
			}
		}
		if (bookHistory == null) {
			return id;
		}
		List<String> list = Arrays.asList(bookHistory.split("\\_"));
		LinkedList<String> linkedList=new LinkedList<String>();
		linkedList.addAll(list);
		if (linkedList.contains(id)) {
			linkedList.remove(id);
			linkedList.addFirst(id);
		}else {
			if (linkedList.size()>=3) {
				linkedList.removeLast();
				linkedList.addFirst(id);
			}else {
				linkedList.addFirst(id);
			}
		}
		
		StringBuffer stringBuffer=new StringBuffer();
		for (String lid : linkedList) {
			stringBuffer.append(lid+"_");
		}
		return stringBuffer.deleteCharAt(stringBuffer.length()-1).toString();
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
