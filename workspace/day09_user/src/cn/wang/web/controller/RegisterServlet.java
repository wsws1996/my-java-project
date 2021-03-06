package cn.wang.web.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import cn.wang.domain.User;
import cn.wang.exception.UserExistException;
import cn.wang.service.BusinessService;
import cn.wang.service.impl.BusinessServiceImpl;
import cn.wang.utils.WebUtils;
import cn.wang.web.formbean.RegisterFormBean;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RegisterFormBean formBean = WebUtils.request2Bean(request,
				RegisterFormBean.class);
		if (!formBean.validate()) {
			request.setAttribute("formbean", formBean);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(
					request, response);
			return;
		}
		User user = new User();
		try {
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.copyProperties(user, formBean);
			user.setId(WebUtils.makeId());
			BusinessService service = new BusinessServiceImpl();
			service.registerUser(user);

			request.setAttribute("message", "注册成功！！！");
			request.getRequestDispatcher("/message.jsp").forward(
					request, response);
		} catch (UserExistException e) {
			formBean.getErrors().put("username", "注册用户已存在！！");
			request.setAttribute("formbean", formBean);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(
					request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "对不起，注册失败！！");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
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
