package com.shopping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shopping.mapper.TbItemMapper;
import com.shopping.pojo.EUDataGridResult;
import com.shopping.pojo.TbItem;
import com.shopping.pojo.TbItemExample;
import com.shopping.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	public TbItemMapper itemMapper;

	@Override
	public EUDataGridResult getItemList(int page, int rows) {
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(page, rows);
		List<TbItem> list = itemMapper.selectByExample(example);

		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		EUDataGridResult result = new EUDataGridResult(total, list);
		return result;
	}

}
