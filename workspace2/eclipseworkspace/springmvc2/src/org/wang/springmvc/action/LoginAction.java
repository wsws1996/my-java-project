package org.wang.springmvc.action;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginAction {

	@RequestMapping("/login")
	public String login(Model model) throws Exception {
		return "login";
	}

	@RequestMapping("/loginsubmit")
	public String loginsubmit(HttpSession session,String userid,String pwd) throws Exception {
		
		session.setAttribute("activeUser", userid);
		return "redirect:stu/querystudent.action";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:stu/querystudent.action";
	}
}
