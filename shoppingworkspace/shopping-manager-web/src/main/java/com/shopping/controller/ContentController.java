package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.pojo.ShoppingResult;
import com.shopping.pojo.TbContent;
import com.shopping.service.ContentService;

@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService contentService;

	@RequestMapping("/save")
	@ResponseBody
	public ShoppingResult insertContent(TbContent content) {
		ShoppingResult result = contentService.insertContent(content);
		return result;
	}
}
