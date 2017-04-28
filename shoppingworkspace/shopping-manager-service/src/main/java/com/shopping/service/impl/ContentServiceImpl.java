package com.shopping.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.shopping.mapper.TbContentMapper;
import com.shopping.pojo.ShoppingResult;
import com.shopping.pojo.TbContent;
import com.shopping.service.ContentService;
import com.shopping.utils.HttpClientUtil;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;

	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${REST_CONTENT_SYNC_URL}")
	private String REST_CONTENT_SYNC_URL;

	@Override
	public ShoppingResult insertContent(TbContent content) {

		content.setCreated(new Date());
		content.setUpdated(new Date());
		contentMapper.insert(content);

		try {
			HttpClientUtil.doGet(REST_BASE_URL + REST_CONTENT_SYNC_URL + content.getCategoryId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ShoppingResult.ok();
	}

}
