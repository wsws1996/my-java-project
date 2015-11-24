package cn.wang.response;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String realpath = this.getServletContext().getRealPath(
				"/download/学校.jpg");

		String filename = realpath.substring(realpath.lastIndexOf("/") + 1);
		response.setHeader("content-disposition", "attachment;filename="
				+ URLEncoder.encode(filename, "UTF-8"));
		FileReader in = new FileReader(realpath);
		int len = 0;
		char buffer[] = new char[1024];
		PrintWriter writer = response.getWriter();
		while ((len = in.read(buffer)) > 0) {
			writer.write(buffer, 0, len);
		}
		in.close();
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
