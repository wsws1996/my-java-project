package cn.wang.test;

import java.sql.*;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection ct = null;
		Statement statement = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// DriverManager.registerDriver(new OracleDriver());
			ct = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "admin");
			statement = ct.createStatement();
			System.out.println(ct);
			/*
			 * int n = statement.executeUpdate(
			 * "insert into user1 values(user1_seq.nextval,'王爽'," +
			 * "'123','weshiwangshuang@163.com',sysdate,18)");
			 */
//			ct.setAutoCommit(false);
//			statement.executeUpdate
//			("update emp set sal=sal+10 where ename='SMITH'");
//			int i=9/0;
//			 statement.executeUpdate
//			("update emp set sal=sal+10 where ename='KING'");
//			 ct.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				System.out.println("try rollback...");
				ct.rollback();
				System.out.println("rollback successed");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				statement = null;
			}
			if (ct != null) {
				try {
					ct.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ct = null;
			}
		}
	}
}
