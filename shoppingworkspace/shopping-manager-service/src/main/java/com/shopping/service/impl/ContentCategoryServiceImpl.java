package com.shopping.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.mapper.TbContentCategoryMapper;
import com.shopping.pojo.EUTreeNode;
import com.shopping.pojo.ShoppingResult;
import com.shopping.pojo.TbContentCategory;
import com.shopping.pojo.TbContentCategoryExample;
import com.shopping.pojo.TbContentCategoryExample.Criteria;
import com.shopping.service.ContentCategoryService;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;

	@Override
	public List<EUTreeNode> getCategoryList(long parentId) {
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
		ArrayList<EUTreeNode> resultList = new ArrayList<>();
		for (TbContentCategory tbContentCategory : list) {
			EUTreeNode node = new EUTreeNode();
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent() ? "closed" : "open");

			resultList.add(node);
		}

		return resultList;
	}

	@Override
	public ShoppingResult insertContentCategory(long parentId, String name) {
		TbContentCategory contentCategory = new TbContentCategory();
		contentCategory.setName(name);
		contentCategory.setIsParent(false);
		contentCategory.setStatus(1);
		contentCategory.setParentId(parentId);
		contentCategory.setSortOrder(1);
		contentCategory.setCreated(new Date());
		contentCategory.setUpdated(new Date());

		contentCategoryMapper.insert(contentCategory);

		TbContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(parentId);

		if (!parentCat.getIsParent()) {
			parentCat.setIsParent(true);

			contentCategoryMapper.updateByPrimaryKey(parentCat);
		}

		return ShoppingResult.ok(contentCategory);
	}

}
