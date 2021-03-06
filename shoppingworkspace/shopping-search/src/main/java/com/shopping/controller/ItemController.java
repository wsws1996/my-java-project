package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.pojo.ShoppingResult;
import com.shopping.service.ItemService;

@Controller
@RequestMapping("/manager")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping("/importall")
	@ResponseBody
	public ShoppingResult importAllItems() {
		ShoppingResult result = itemService.importAllItems();
		return result;
	}

}
