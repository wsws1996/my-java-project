package cn.wang.utils;

import java.sql.ResultSet;


public class IntegerHandler implements ResultSetHandler {

	@Override
	public Object handler(ResultSet resultSet) {
		try {
			if (!resultSet.next()) {
				return 0;
			}
			return resultSet.getObject(1);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
