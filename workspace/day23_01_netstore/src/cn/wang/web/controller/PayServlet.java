package cn.wang.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wang.domain.Order;
import cn.wang.service.BussinessService;
import cn.wang.service.impl.BussinessServiceImpl;
import cn.wang.util.PaymentUtil;

public class PayServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5032302913909895446L;
	private BussinessService service=new BussinessServiceImpl();
	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ordernum = request.getParameter("ordernum");
		String pd_FrpId=request.getParameter("pd_FrpId");
		
		String p0_Cmd="Buy";
		String p1_MerId="10001126856";
		String p2_Order=ordernum;
		String p3_Amt="0.01";
		String p4_Cur="CNY";
		String p5_Pid="unknown";
		String p6_Pcat="unknown";
		String p7_Pdesc="unknown";
		String p8_Url="http://localhost:8080/day23_01_netstore/servlet/ResponseServlet";
		String p9_SAF="1";
		String pa_MP="unknown";
		String pr_NeedResponse ="1";
		String hmac=PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl");
		request.setAttribute("p0_Cmd",p0_Cmd );
		request.setAttribute("p1_MerId",p1_MerId );
		request.setAttribute("p2_Order",p2_Order );
		request.setAttribute("p3_Amt", "0.01");
		request.setAttribute("p4_Cur", "CNY");
		request.setAttribute("p5_Pid","unknown" );
		request.setAttribute("p6_Pcat","unknown" );
		request.setAttribute("p7_Pdesc", "unknown");
		request.setAttribute("p8_Url","http://localhost:8080/day23_01_netstore/servlet/ResponseServlet" );
		request.setAttribute("p9_SAF", "1");
		request.setAttribute("pa_MP","unknown" );
		request.setAttribute("pr_NeedResponse","1" );
		request.setAttribute("pd_FrpId",pd_FrpId );
		request.setAttribute("hmac",hmac );

		Order order = service.findOrderByNum(ordernum);
		order.setStatus(1);
		service.changeOrderStatus(order);
		
		request.getRequestDispatcher("/sure.jsp").forward(request, response);
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
