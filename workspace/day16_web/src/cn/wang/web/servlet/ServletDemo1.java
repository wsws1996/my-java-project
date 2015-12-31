package cn.wang.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wang.dao.BaseDao;

public class ServletDemo1 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5449407490867518176L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BaseDao dao=new BaseDao();
		dao.add();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
