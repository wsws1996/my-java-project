package com.wang.ssm.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wang.ssm.po.User;
import com.wang.ssm.service.UserService;

@Controller
@RequestMapping("/user")
public class UserAction {

	@Autowired
	private UserService userService;

	@RequestMapping("queryUser")
	public String queryUser(Model model, Integer id) throws Exception {
		User user = userService.findUserById(id);
		model.addAttribute("user", user);
		return "queryUser";
	}
}
