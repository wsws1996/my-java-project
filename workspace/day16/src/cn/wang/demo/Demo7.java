package cn.wang.demo;

import java.sql.SQLException;

import cn.wang.dao.AccountDao;

public class Demo7 {

	public static void main(String[] args) throws SQLException {
		AccountDao dao = new AccountDao();
		System.out.println(dao.getAll().size());
	}

}
