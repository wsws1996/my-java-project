package com.shopping.service;

import java.util.List;

import com.shopping.pojo.TbContent;

public interface ContentService {
	public List<TbContent> getContentList(long contentId);
}
