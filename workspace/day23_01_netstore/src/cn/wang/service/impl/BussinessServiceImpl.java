package cn.wang.service.impl;

import java.util.List;

import cn.wang.commons.Page;
import cn.wang.dao.BookDao;
import cn.wang.dao.CategoryDao;
import cn.wang.dao.impl.BookDaoImpl;
import cn.wang.dao.impl.CategoryDaoImpl;
import cn.wang.domain.Book;
import cn.wang.domain.Category;
import cn.wang.service.BussinessService;
import cn.wang.util.IdGenertor;

//开发主线：业务主线
public class BussinessServiceImpl implements BussinessService {

	private CategoryDao categoryDao = new CategoryDaoImpl();
	private BookDao bookDao = new BookDaoImpl();

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
				page.getPageSize(),categoryId);
		page.setRecords(records);
		return page;
	}

}
