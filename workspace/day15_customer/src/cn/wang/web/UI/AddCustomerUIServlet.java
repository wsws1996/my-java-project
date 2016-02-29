package cn.wang.web.UI;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wang.utils.Globals;

public class AddCustomerUIServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4348004888295153933L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("preferences", Globals.preferences);
		request.setAttribute("types", Globals.types);
		request.getRequestDispatcher("/WEB-INF/jsp/addcustomer.jsp").forward(
				request, response);
		;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
