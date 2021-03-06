package com.shopping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.mapper.TbItemCatMapper;
import com.shopping.pojo.TbItemCat;
import com.shopping.pojo.TbItemCatExample;
import com.shopping.pojo.TbItemCatExample.Criteria;
import com.shopping.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;

	@Override
	public List<TbItemCat> getItemCatList(Long parentId) {
		TbItemCatExample example = new TbItemCatExample();

		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);

		List<TbItemCat> list = itemCatMapper.selectByExample(example);

		return list;
	}

}
