package org.wang.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Hello implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("message", "hello world well!");
//		modelAndView.setViewName("/WEB-INF/jsp/hello.jsp");
		modelAndView.setViewName("hello");
		return modelAndView;
	}

}
