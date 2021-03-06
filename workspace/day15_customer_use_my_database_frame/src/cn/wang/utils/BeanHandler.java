package cn.wang.utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


public class BeanHandler implements ResultSetHandler {
	@SuppressWarnings("rawtypes")
	private Class clazz;

	public BeanHandler(@SuppressWarnings("rawtypes") Class clazz) {
		this.clazz = clazz;
	}

	@Override
	public Object handler(ResultSet resultSet) {
		try {
			if (!resultSet.next()) {
				return null;
			}
			Object bean = clazz.newInstance();
			ResultSetMetaData metaData = resultSet.getMetaData();
			int columnCount = metaData.getColumnCount();
			for (int i = 0; i < columnCount; i++) {
				String coulmnName = metaData.getColumnName(i + 1);
				Object coulmnData = resultSet.getObject(i + 1);

				Field field = clazz.getDeclaredField(coulmnName);// 反射出类上列名对应的属性
				field.setAccessible(true);
				field.set(bean, coulmnData);
			}
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}