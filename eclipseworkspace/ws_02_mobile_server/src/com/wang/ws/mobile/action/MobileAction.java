package com.wang.ws.mobile.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wang.ws.mobile.service.MobileService;

@Controller
public class MobileAction {

	@Autowired
	private MobileService mobileService;

	@RequestMapping("/queryMobile")
	public String queryMobile(Model model, String code) {
		String result = null;
		if (code != null && !code.equals("")) {
			result = mobileService.queryMobile(code);
		}

		model.addAttribute("result", result);
		return "queryMobile";
	}
}
