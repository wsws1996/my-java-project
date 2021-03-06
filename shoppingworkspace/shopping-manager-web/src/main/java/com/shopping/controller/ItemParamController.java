package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.pojo.EUDataGridResult;
import com.shopping.pojo.ShoppingResult;
import com.shopping.pojo.TbItemParam;
import com.shopping.service.ItemParamService;

@Controller
@RequestMapping("/item/param")
public class ItemParamController {
	@Autowired
	private ItemParamService itemParamService;

	@RequestMapping("/query/itemcatid/{itemCatId}")
	@ResponseBody
	public ShoppingResult getItemParamByCid(@PathVariable Long itemCatId) {
		ShoppingResult result = itemParamService.getItemParamByCid(itemCatId);
		return result;
	}

	@RequestMapping("/save/{cid}")
	@ResponseBody
	public ShoppingResult insertItemParam(@PathVariable Long cid, String paramData) {
		TbItemParam itemParam = new TbItemParam();
		itemParam.setItemCatId(cid);
		itemParam.setParamData(paramData);
		ShoppingResult result = itemParamService.insertItemParam(itemParam);
		return result;
	}

	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemParamList(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "30") Integer rows) {
		EUDataGridResult result = itemParamService.getItemParamList(page, rows);
		return result;
	}

}
