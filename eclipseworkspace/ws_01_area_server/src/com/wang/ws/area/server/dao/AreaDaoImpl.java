package com.wang.ws.area.server.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wang.ws.area.server.po.Area;

public class AreaDaoImpl implements AreaDao {

	private static String sql = "SELECT * from area where PARENTID=? limit ?,?";

	@Override
	public List<Area> queryAreaList(String parentid, int start, int pageSize) {

		Connection connection = null;

		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		List<Area> areaList = new ArrayList<Area>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webservice", "root", "root");
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, parentid);
			preparedStatement.setInt(2, start);
			preparedStatement.setInt(3, pageSize);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Area area = new Area();
				area.setAreaid(resultSet.getString("areaid"));
				area.setAreaname(resultSet.getString("areaname"));
				area.setArealevel(resultSet.getString("arealevel"));
				area.setParentid(resultSet.getString("parentid"));
				areaList.add(area);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return areaList;
	}

}
