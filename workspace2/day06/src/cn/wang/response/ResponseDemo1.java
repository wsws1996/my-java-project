package cn.wang.response;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		test3(response);
	}

	public void test3(HttpServletResponse response) throws IOException {
		String data = "中国";
		response.setContentType( "text/html;charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
		printWriter.write(data);
	}

	public void test2(HttpServletResponse response) throws IOException,
			UnsupportedEncodingException {
		String data = "中国";
		OutputStream outputStream = response.getOutputStream();
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		outputStream
				.write("<meta http-equiv='Content-type' content='text/html;charset=GB2312'>"
						.getBytes());
		outputStream.write(data.getBytes("UTF-8"));
	}

	public void test1(HttpServletResponse response) throws IOException {
		response.setHeader("content-type", "text/html;charset=UTF-8");
		String data = "中国";
		OutputStream outputStream = response.getOutputStream();
		outputStream.write(data.getBytes());
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
