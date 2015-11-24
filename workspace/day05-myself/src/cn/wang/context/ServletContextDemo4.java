package cn.wang.context;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextDemo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String data="<h1><font color='red'>nnfgmnghv</font></h1>";
//		response.getOutputStream().write(data.getBytes());
		OutputStream outputStream= response.getOutputStream();
		outputStream.write("11111".getBytes());
		outputStream.close();
		ServletContext context=this.getServletContext();
			RequestDispatcher requestDispatcher= context.getRequestDispatcher("/servlet/ServletContextDemo5");
			requestDispatcher.forward(request, response);
			response.getOutputStream().write("4444".getBytes());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
