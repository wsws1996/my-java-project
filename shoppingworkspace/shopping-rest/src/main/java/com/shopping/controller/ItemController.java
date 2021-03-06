package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.pojo.ShoppingResult;
import com.shopping.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping("/info/{itemId}")
	@ResponseBody
	public ShoppingResult getItemBaseInfo(@PathVariable Long itemId) {
		ShoppingResult result = itemService.getItemBaseInfo(itemId);
		return result;
	}

	@RequestMapping("/desc/{itemId}")
	@ResponseBody
	public ShoppingResult getItemDesc(@PathVariable Long itemId) {
		ShoppingResult result = itemService.getItemDesc(itemId);
		return result;
	}

	@RequestMapping("/param/{itemId}")
	@ResponseBody
	public ShoppingResult getItemParam(@PathVariable Long itemId) {
		ShoppingResult result = itemService.getItemParam(itemId);
		return result;
	}
}
