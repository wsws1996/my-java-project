package cn.wang.test;

import java.sql.*;

public class TestJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection ct = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			ct = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "admin");
			ps = ct.prepareStatement("select * from user1 where id=? and passwd=?");
			ps.setInt(1, 2);
			ps.setString(2, "232445 ' or 1=1");
			rs=ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("id") + " 名字：" + rs.getString("name"));
			}
			/*rs.beforeFirst();
			System.out.println("************");
			while (rs.next()) {
				System.out.println(rs.getInt("id") + " 名字：" + rs.getString("name"));
			}*/
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rs = null;
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ps = null;
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
