package cn.wang.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {
	private static SessionFactory factory;
	static {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return factory;
	}

	public static Session getSession() {
		Session session = factory.openSession();
		return session;
	}
}
