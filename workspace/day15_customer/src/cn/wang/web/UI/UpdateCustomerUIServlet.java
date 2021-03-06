package cn.wang.web.UI;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wang.domain.Customer;
import cn.wang.service.impl.BussinessService;
import cn.wang.utils.Globals;

public class UpdateCustomerUIServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4014116000445349323L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		BussinessService service=new BussinessService();
		Customer customer= service.findCustomer(id);
		request.setAttribute("customer", customer);
		request.setAttribute("types", Globals.types);
		request.setAttribute("preferences", Globals.preferences);
		request.getRequestDispatcher("/WEB-INF/jsp/updatecustomer.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	
}
