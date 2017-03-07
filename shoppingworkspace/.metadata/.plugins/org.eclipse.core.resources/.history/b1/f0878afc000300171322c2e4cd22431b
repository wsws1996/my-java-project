package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.pojo.EUDataGridResult;
import com.shopping.pojo.TbItem;
import com.shopping.pojo.TbItemDesc;
import com.shopping.result.ShoppingResult;
import com.shopping.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemService itemService;

	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemlist(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "30") Integer rows) {
		EUDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}

	@RequestMapping("/save")
	@ResponseBody
	public ShoppingResult addItem(TbItem item, String desc) {
		TbItemDesc itemDesc = new TbItemDesc();
		itemDesc.setItemDesc(desc);
		ShoppingResult result = itemService.addItem(item, itemDesc);
		return result;
	}
}
