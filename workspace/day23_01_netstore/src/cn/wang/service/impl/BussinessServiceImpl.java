package cn.wang.service.impl;

import java.util.List;

import cn.wang.commons.Page;
import cn.wang.dao.BookDao;
import cn.wang.dao.CategoryDao;
import cn.wang.dao.CustomerDao;
import cn.wang.dao.OrderDao;
import cn.wang.dao.PrivilegeDao;
import cn.wang.dao.impl.BookDaoImpl;
import cn.wang.dao.impl.CategoryDaoImpl;
import cn.wang.dao.impl.CustomerDaoImpl;
import cn.wang.dao.impl.OrderDaoImpl;
import cn.wang.dao.impl.PrivilegeDaoImpl;
import cn.wang.domain.Book;
import cn.wang.domain.Category;
import cn.wang.domain.Customer;
import cn.wang.domain.Function;
import cn.wang.domain.Order;
import cn.wang.domain.Role;
import cn.wang.domain.User;
import cn.wang.service.BussinessService;
import cn.wang.util.IdGenertor;

//开发主线：业务主线
public class BussinessServiceImpl implements BussinessService {

	private CategoryDao categoryDao = new CategoryDaoImpl();
	private BookDao bookDao = new BookDaoImpl();
	private CustomerDao customerDao = new CustomerDaoImpl();
	private OrderDao orderDao = new OrderDaoImpl();
	private PrivilegeDao privilegeDao = new PrivilegeDaoImpl();

	@Override
	public void addCategory(Category category) {
		category.setId(IdGenertor.getUUID());
		categoryDao.save(category);
	}

	@Override
	public List<Category> findAllCategories() {
		return categoryDao.findAll();
	}

	@Override
	public Category findCategoryById(String categoryId) {

		return categoryDao.findById(categoryId);
	}

	@Override
	public void addBook(Book book) {
		if (book == null) {
			throw new IllegalArgumentException("the book can not be null");
		}
		if (book.getCategory() == null) {
			throw new IllegalArgumentException(
					"the book's category can not be null");
		}
		book.setId(IdGenertor.getUUID());
		bookDao.save(book);
	}

	@Override
	public Book findBookById(String bookId) {
		return bookDao.findBookById(bookId);
	}

	@Override
	public Page findBookPageRecords(String num) {
		int pageNum = 1;
		if (num != null && !num.equals("")) {
			pageNum = Integer.parseInt(num);
		}
		int totalRecordsNum = bookDao.getTotalRecordsNum();
		Page page = new Page(pageNum, totalRecordsNum);
		List<Book> records = bookDao.findPageRecords(page.getStartIndex(),
				page.getPageSize());
		page.setRecords(records);
		return page;
	}

	@Override
	public Page findBookPageRecords(String num, String categoryId) {
		int pageNum = 1;
		if (num != null && !num.equals("")) {
			pageNum = Integer.parseInt(num);
		}
		int totalRecordsNum = bookDao.getTotalRecordsNum(categoryId);
		Page page = new Page(pageNum, totalRecordsNum);
		List<Book> records = bookDao.findPageRecords(page.getStartIndex(),
				page.getPageSize(), categoryId);
		page.setRecords(records);
		return page;
	}

	@Override
	public void addCustomer(Customer customer) {
		customer.setId(IdGenertor.getUUID());
		customerDao.save(customer);
	}

	@Override
	public Customer findCustomer(String customerId) {

		return customerDao.findOne(customerId);
	}

	@Override
	public Customer customerLogin(String username, String password) {
		return customerDao.find(username, password);
	}

	@Override
	public void genOrder(Order order) {
		if (order.getCustomer() == null) {
			throw new IllegalArgumentException("订单中不存在客户信息");
		}
		if (order.getItems() == null || order.getItems().size() == 0) {
			throw new IllegalArgumentException("订单中不存在订单项信息");
		}
		orderDao.save(order);
	}

	@Override
	public Order findOrderByNum(String ordernum) {

		return orderDao.findByNum(ordernum);
	}

	@Override
	public List<Order> findCustomerOrders(Customer customer) {
		return orderDao.findByCustomer(customer.getId());
	}

	@Override
	public void changeOrderStatus(Order order) {
		orderDao.updateStatus(order);
	}

	@Override
	public User login(String username, String password) {
		return privilegeDao.find(username,password);
	}

	@Override
	public List<Role> findRolesByUser(User user) {
		return privilegeDao.findRolesByUser(user);
	}

	@Override
	public List<Function> findFunctionsByRole(Role role) {
		return privilegeDao.findFunctionsByRole(role);
	}

}
