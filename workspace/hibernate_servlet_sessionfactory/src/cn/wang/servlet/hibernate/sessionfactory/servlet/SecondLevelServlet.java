package cn.wang.servlet.hibernate.sessionfactory.servlet;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import cn.wang.servlet.hibernate.sessionfactory.domain.Privilege;
import cn.wang.servlet.hibernate.sessionfactory.utils.HibernateUtils;

public class SecondLevelServlet extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Session session = HibernateUtils.sessionFactory.openSession();
		Iterator iterator = session.createQuery(
				"from Privilege").iterate();
		while (iterator.hasNext()) {
			System.out.println( iterator.next());

		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
