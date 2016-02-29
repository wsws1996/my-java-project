package cn.wang.dao;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BaseDao {
	public void add() {
		try {
			Context initCtx = new InitialContext();// 初始化jndi
			Context envCtx = (Context) initCtx.lookup("java:comp/env");// 得到jndi容器
			DataSource ds = (DataSource) envCtx.lookup("jdbc/EmployeeDB");// 从容器中检索连接池
			Connection conn = ds.getConnection();
			System.out.println(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
