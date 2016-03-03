package cn.wang.servlet.hibernate.sessionfactory.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import cn.wang.servlet.hibernate.sessionfactory.dao.PrivilegeDao;

public class PrivilegeListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		PrivilegeDao privilegeDao = new PrivilegeDao();
		privilegeDao.putPrivilegesToSecondLevel();
	}

}
