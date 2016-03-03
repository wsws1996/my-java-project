package cn.wang.dao;

import java.util.List;

import cn.wang.domain.Book;

public interface BookDao {

	void save(Book book);
	
	/**
	 * 把书籍对应的分类也查询出来
	 * @param bookId 
	 * @return
	 */
	Book findBookById(String bookId);
	/**
	 * 获取书籍的总记录数
	 * @return
	 */
	int getTotalRecordsNum();
	/**
	 * 分页查询，把书籍对应的分类也查询出来
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<Book> findPageRecords(int startIndex, int pageSize);

	int getTotalRecordsNum(String categoryId);

	List<Book> findPageRecords(int startIndex, int pageSize, String categoryId);

}
