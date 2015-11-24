package cn.wang.dao;

import java.util.Map;

import cn.wang.db.MyDb;
import cn.wang.domain.Book;

public class BookDao {
	public Map getAll() {
		return MyDb.getAll();
	}

	public Book find(String id) {
		return (Book) MyDb.getAll().get(id);
	}
}
