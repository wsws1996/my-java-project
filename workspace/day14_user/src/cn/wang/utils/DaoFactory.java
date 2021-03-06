package cn.wang.utils;

import java.io.InputStream;
import java.util.Properties;

import cn.wang.dao.UserDao;

public class DaoFactory {

	private UserDao userDao = null;

	private DaoFactory() {
		try {
			InputStream inputStream = DaoFactory.class.getClassLoader()
					.getResourceAsStream("dao.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			String daoClassName = properties.getProperty("userdao");
			userDao = (UserDao) Class.forName(daoClassName).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static final DaoFactory instance = new DaoFactory();

	public static DaoFactory getInstance() {
		return instance;
	}

	public UserDao createDao() {
		return userDao;
	}
}
