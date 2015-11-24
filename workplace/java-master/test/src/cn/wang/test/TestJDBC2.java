package cn.wang.test;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class TestJDBC2 {
	@Test
	public void testSqlHelper() {
		String sql = "insert into user1 values(USER1_SEQ.nextval,?,?,?,sysdate,?)";
		String[] parameters = { "小红", "123", "xiaohong@sohu.com", "50" };
		SqlHelper.executeUpdate(sql, parameters);
	}

	@Test
	public void testSqlHelper2() {
		String sql1 = "update emp set sal=sal-10 where ename=?";
		String sql2 = "update emp set sal=sal+10 where ename=?";
		String sqls[] = { sql1, sql2 };
		String sql1_paras[] = { "SMITH" };
		String sql2_paras[] = { "KING" };
		String[][] parameters = { sql1_paras, sql2_paras };

		SqlHelper.executeUpdate2(sqls, parameters);
	}

	@Test
	public void testSqlHelper3() throws SQLException {
		try {
			String sql = "select * from emp";
			ResultSet rs = SqlHelper.executeQuery(sql, null);
			System.out.println(SqlHelper.getRs());
			while (rs.next()) {
				System.out.println(rs.getString("ename") + " " + rs.getFloat("sal"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			System.out.println(SqlHelper.getRs());
			SqlHelper.close(SqlHelper.getRs(), SqlHelper.getPs(), SqlHelper.getCt());
		}
	}

	@Test
	public void testSql4() {
		try {
			String sql = "{call prol(?,?)}";
			String parameters[] = { "56", "王爽" };
			SqlHelper.callPro1(sql, parameters);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Test
	public void testSql5() {
		ResultSet rs = null;
		try {
			String sql = "{call pro2 (?,?)}";
			String[] in = { "20" };
			Integer[] out = { oracle.jdbc.OracleTypes.CURSOR };
			CallableStatement cs = SqlHelper.callprol2(sql, in, out);
			rs = (ResultSet) cs.getObject(2);
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			SqlHelper.close(rs, SqlHelper.getCs(), SqlHelper.getCt());
		}
	}
}
