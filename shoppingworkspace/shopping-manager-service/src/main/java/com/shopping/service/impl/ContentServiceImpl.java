package com.shopping.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.mapper.TbContentMapper;
import com.shopping.pojo.ShoppingResult;
import com.shopping.pojo.TbContent;
import com.shopping.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;

	@Override
	public ShoppingResult insertContent(TbContent content) {

		content.setCreated(new Date());
		content.setUpdated(new Date());
		contentMapper.insert(content);

		return ShoppingResult.ok();
	}

}
