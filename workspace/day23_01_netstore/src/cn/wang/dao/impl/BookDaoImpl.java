package cn.wang.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.wang.dao.BookDao;
import cn.wang.domain.Book;
import cn.wang.domain.Category;
import cn.wang.util.DBCPUtil;

public class BookDaoImpl implements BookDao {
	private QueryRunner queryRunner = new QueryRunner(DBCPUtil.getDataSource());

	@Override
	public void save(Book book) {
		try {
			queryRunner
					.update("insert into books(id,name,author,price,path,filename,description,categoryId) values(?,?,?,?,?,?,?,?)",
							book.getId(), book.getName(), book.getAuthor(),
							book.getPrice(), book.getPath(),
							book.getFilename(), book.getDescription(), book
									.getCategory().getId());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Book findBookById(String bookId) {
		try {
			Book book = queryRunner.query("select * from books where id=?",
					new BeanHandler<Book>(Book.class), bookId);
			if (book != null) {
				Category category = queryRunner
						.query("select * from categorys where id=(select categoryid from books where id=?)",
								new BeanHandler<Category>(Category.class),
								bookId);
				book.setCategory(category);
			}
			return book;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getTotalRecordsNum() {
		try {
			Object object = queryRunner.query("select count(*) from books",
					new ScalarHandler<Integer>(1));
			Long num = (long) object;
			return num.intValue();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Book> findPageRecords(int startIndex, int pageSize) {
		try {
			List<Book> books = queryRunner.query(
					"select * from books limit ?,?", new BeanListHandler<Book>(
							Book.class), startIndex, pageSize);
			if (books != null && books.size() > 0) {
				for (Book book : books) {
					Category category = queryRunner
							.query("select * from categorys where id=(select categoryid from books where id=?)",
									new BeanHandler<Category>(Category.class),
									book.getId());
					book.setCategory(category);
				}

			}
			return books;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getTotalRecordsNum(String categoryId) {
		try {
			Object object = queryRunner.query(
					"select count(*) from books where categoryId=?",
					new ScalarHandler<Integer>(1), categoryId);
			Long num = (long) object;
			return num.intValue();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Book> findPageRecords(int startIndex, int pageSize,
			String categoryId) {
		try {
			List<Book> books = queryRunner.query(
					"select * from books  where categoryId=? limit ?,?",
					new BeanListHandler<Book>(Book.class), categoryId,
					startIndex, pageSize);
			if (books != null && books.size() > 0) {
				for (Book book : books) {
					Category category = queryRunner
							.query("select * from categorys where id=?",
									new BeanHandler<Category>(Category.class),
									categoryId);
					book.setCategory(category);
				}

			}
			return books;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
