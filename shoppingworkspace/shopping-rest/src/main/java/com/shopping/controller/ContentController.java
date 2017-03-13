package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.pojo.ShoppingResult;
import com.shopping.pojo.TbContent;
import com.shopping.service.ContentService;
import com.shopping.utils.ExceptionUtil;

@Controller
@RequestMapping("/content")
public class ContentController {
	@Autowired
	private ContentService contentService;

	@RequestMapping("/list/{contentCategoryId}")
	@ResponseBody
	public ShoppingResult getContentList(@PathVariable Long contentCategoryId) {
		try {
			List<TbContent> list = contentService.getContentList(contentCategoryId);
			return ShoppingResult.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
			return ShoppingResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
}
