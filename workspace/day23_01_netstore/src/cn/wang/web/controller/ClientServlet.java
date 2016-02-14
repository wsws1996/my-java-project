package cn.wang.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wang.commons.Page;
import cn.wang.constant.Constants;
import cn.wang.domain.Book;
import cn.wang.domain.Category;
import cn.wang.domain.Customer;
import cn.wang.domain.Order;
import cn.wang.domain.OrderItem;
import cn.wang.service.BussinessService;
import cn.wang.service.impl.BussinessServiceImpl;
import cn.wang.util.IdGenertor;
import cn.wang.util.WebUtil;
import cn.wang.web.beans.Cart;
import cn.wang.web.beans.CartItem;

public class ClientServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1820793600450200288L;
	private BussinessService service = new BussinessServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		if ("showIndex".equals(op)) {
			showIndex(request, response);
		} else if ("showCategoryBooks".equals(op)) {
			showCategoryBooks(request, response);
		} else if ("showBookdetail".equals(op)) {
			showBookdetail(request, response);
		} else if ("buy".equals(op)) {
			buy(request, response);
		} else if ("changeNum".equals(op)) {
			changeNum(request, response);
		} else if ("delOneItem".equals(op)) {
			delOneItem(request, response);
		} else if ("delAllItems".equals(op)) {
			delAllItems(request, response);
		} else if ("registerCustomer".equals(op)) {
			registerCustomer(request, response);
		} else if ("customerLogin".equals(op)) {
			customerLogin(request, response);
		} else if ("customerLogout".equals(op)) {
			customerLogout(request, response);
		} else if ("genOrder".equals(op)) {
			genOrder(request, response);
		} else if ("showCustomerOrders".equals(op)) {
			showCustomerOrders(request, response);
		}
	}

	private void showCustomerOrders(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 验证用户是否登录
		HttpSession session = request.getSession();
		Customer customer = (Customer) session
				.getAttribute(Constants.CUSTOMER_LOGIN_FLAG);
		// 没有登录：去登录
		if (customer == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}
		List<Order> orders= service.findCustomerOrders(customer);
		request.setAttribute("os", orders);
		request.getRequestDispatcher("/showCustomerOrders.jsp").forward(request, response);
	}

	// 生成订单
	private void genOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 验证用户是否登录
		HttpSession session = request.getSession();
		Customer customer = (Customer) session
				.getAttribute(Constants.CUSTOMER_LOGIN_FLAG);
		// 没有登录：去登录
		if (customer == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}
		// 已登录
		// 取出购物车信息------->order订单号没有
		// 取出购物项信息------->OrderItem id没有
		Cart cart = (Cart) session.getAttribute(Constants.HTTPSESSION_CART);
		if (cart == null) {
			response.getWriter().write("会话超时！");
			return;
		}
		Order order = new Order();
		order.setOrdernum(IdGenertor.genOrdernum());
		order.setQuantity(cart.getTotalQuntity());
		order.setMoney(cart.getTotalMoney());
		order.setCustomer(customer);
		// 生成订单项
		List<OrderItem> orderItems = new ArrayList<>();
		for (Map.Entry<String, CartItem> me : cart.getItems().entrySet()) {
			CartItem cartItem = me.getValue();
			OrderItem orderItem = new OrderItem();
			orderItem.setId(IdGenertor.getUUID());
			orderItem.setBook(cartItem.getBook());
			orderItem.setPrice(cartItem.getMoney());
			orderItem.setQuantity(cartItem.getQuantity());
			orderItems.add(orderItem);
		}
		// 将订单项绑定到订单
		order.setItems(orderItems);
		// 保存订单，跳转到在线支付
		service.genOrder(order);
		request.setAttribute("order", order);
		request.getRequestDispatcher("/pay.jsp").forward(request, response);
	}

	private void customerLogout(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute(Constants.CUSTOMER_LOGIN_FLAG);
		response.sendRedirect(request.getContextPath());
	}

	private void customerLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Customer customer = service.customerLogin(username, password);
		request.getSession().setAttribute(Constants.CUSTOMER_LOGIN_FLAG,
				customer);
		response.sendRedirect(request.getContextPath());
	}

	private void registerCustomer(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Customer customer = WebUtil.fillBean(request, Customer.class);
		service.addCustomer(customer);
		response.getWriter().write("登录成功，2秒后转向主页");
		response.setHeader("refresh", "2;URL=" + request.getContextPath());
	}

	private void delAllItems(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute(Constants.HTTPSESSION_CART);
		response.sendRedirect(request.getContextPath() + "/showCart.jsp");
	}

	private void delOneItem(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String bookId = request.getParameter("bookId");
		Cart cart = (Cart) request.getSession().getAttribute(
				Constants.HTTPSESSION_CART);
		cart.getItems().remove(bookId);
		response.sendRedirect(request.getContextPath() + "/showCart.jsp");
	}

	private void changeNum(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		String bookId = request.getParameter("bookId");
		Cart cart = (Cart) request.getSession().getAttribute(
				Constants.HTTPSESSION_CART);
		cart.getItems().get(bookId).setQuantity(Integer.parseInt(num));
		response.sendRedirect(request.getContextPath() + "/showCart.jsp");
	}

	private void buy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookId = request.getParameter("bookId");
		Book book = service.findBookById(bookId);
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute(Constants.HTTPSESSION_CART);
		if (cart == null) {
			cart = new Cart();
			session.setAttribute(Constants.HTTPSESSION_CART, cart);
		}
		cart.addBook(book);
		response.getWriter().write("购买成功，2秒后转向主页");
		response.setHeader("refresh", "2;URL=" + request.getContextPath());
	}

	private void showBookdetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String bookId = request.getParameter("bookId");
		Book book = service.findBookById(bookId);
		request.setAttribute("book", book);
		request.getRequestDispatcher("/bookDetail.jsp").forward(request,
				response);
	}

	private void showCategoryBooks(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Category> categories = service.findAllCategories();
		request.setAttribute("cs", categories);
		String num = request.getParameter("num");
		String categoryId = request.getParameter("categoryId");
		Page page = service.findBookPageRecords(num, categoryId);
		page.setUrl("/client/ClientServlet?op=showCategoryBooks&categoryId="
				+ categoryId);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/listBooks.jsp").forward(request,
				response);
	}

	// 展现主页
	private void showIndex(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Category> categories = service.findAllCategories();
		request.setAttribute("cs", categories);
		String num = request.getParameter("num");
		Page page = service.findBookPageRecords(num);
		page.setUrl("/client/ClientServlet?op=showIndex");
		request.setAttribute("page", page);
		request.getRequestDispatcher("/listBooks.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
