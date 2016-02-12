package cn.wang.service;

import java.util.List;

import cn.wang.commons.Page;
import cn.wang.domain.Book;
import cn.wang.domain.Category;

public interface BussinessService {
	/**
	 * 添加分类
	 * @param category
	 */
	void addCategory(Category category);
	/**
	 * 查询所有的分类
	 * @return
	 */
	List<Category> findAllCategories();
	/**
	 * 根据id查询分类
	 * @param categoryId
	 * @return 没有找到返回null
	 */
	Category findCategoryById(String categoryId);
	/**
	 * 添加书籍
	 * @param book
	 * 如果book关联的Category为null，要抛出参数错误异常
	 */
	void addBook(Book book);
	/**
	 * 
	 * @param bookId
	 * @return book和分类
	 */
	Book findBookById(String bookId);
	/**
	 * 根据用户要查看的页码，返回封装了所有与分页有关的Page对象
	 * @param num 要看的页码，如果为null或“”，默认为1
	 * @return
	 */
	Page findBookPageRecords(String num);
	Page findBookPageRecords(String num, String categoryId);
}
