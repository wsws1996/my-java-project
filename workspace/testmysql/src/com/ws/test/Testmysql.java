package com.ws.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Testmysql {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection ct = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/wsdb1?useUnicode=true&amp;characterEncoding=gb2312","root",null);
			ps=ct.prepareStatement("select * from student");
			rs=ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("id")+","+rs.getString("name")+","+rs.getFloat("chinese"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (rs!=null) {
				rs.close();
			}
			rs=null;
			if (ps!=null) {
				ps.close();
			}
			ps=null;
			if(ct!=null){
				ct.close();
			}
			ct=null;
		}
	}

}
