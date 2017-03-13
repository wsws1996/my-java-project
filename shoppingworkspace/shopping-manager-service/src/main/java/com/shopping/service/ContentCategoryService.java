package com.shopping.service;

import java.util.List;

import com.shopping.pojo.EUTreeNode;
import com.shopping.pojo.ShoppingResult;

public interface ContentCategoryService {
	public List<EUTreeNode> getCategoryList(long parentId);

	public ShoppingResult insertContentCategory(long parentId, String name);
}
