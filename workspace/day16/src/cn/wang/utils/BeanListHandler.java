package cn.wang.utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;


public class BeanListHandler implements ResultSetHandler {
	@SuppressWarnings("rawtypes")
	private Class clazz;

	public BeanListHandler(@SuppressWarnings("rawtypes") Class clazz) {
		this.clazz = clazz;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object handler(ResultSet resultSet) {

		try {
			@SuppressWarnings("rawtypes")
			List list = new ArrayList();
			while (resultSet.next()) {
				Object bean = clazz.newInstance();
				ResultSetMetaData metaData = resultSet.getMetaData();
				int columnCount = metaData.getColumnCount();
				for (int i = 0; i < columnCount; i++) {
					String columnName = metaData.getColumnName(i + 1);
					Object value = resultSet.getObject(columnName);

					Field field = bean.getClass().getDeclaredField(columnName);
					field.setAccessible(true);
					field.set(bean, value);
				}
				list.add(bean);
			}
			return list.size() > 0 ? list : null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}