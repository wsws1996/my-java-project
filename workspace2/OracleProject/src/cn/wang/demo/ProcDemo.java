package cn.wang.demo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class ProcDemo {
	public final static String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	public final static String DBURL = "jdbc:oracle:thin:@localhost:1521:ORCL";
	public final static String DBUSER = "scott";
	public final static String DBPASS = "admin";

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Connection conn;
		CallableStatement cstmt=null;
		String sql="{call mldn_proc(?,?,?)}";
		Class.forName(DBDRIVER);
		conn=DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		cstmt=conn.prepareCall(sql);
		cstmt.setInt(1, 70);
		cstmt.setInt(2, 80);
		cstmt.registerOutParameter(2, Types.INTEGER);
		cstmt.registerOutParameter(3, Types.INTEGER);
		cstmt.execute();
		System.out.println("in out:"+cstmt.getInt(2));
		System.out.println("out:"+cstmt.getInt(3));
		cstmt.close();
		conn.close();
	}

}
