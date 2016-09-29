package com.wang.core.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台管理 测试
 * 
 * @author wang
 *
 */
@Controller
public class ProductController {
	@RequestMapping(value = "/test/springmvc.do")
	public String test(String name, Date birthday) {
		System.out.println(name + ":" + birthday);
		return "";
	}

//	@InitBinder
//	public void initBinder(WebDataBinder binder, WebRequest request) {
		//转换日期格式
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//	}
}
