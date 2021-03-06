package com.shopping.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shopping.mapper.TbItemDescMapper;
import com.shopping.mapper.TbItemMapper;
import com.shopping.mapper.TbItemParamItemMapper;
import com.shopping.pojo.EUDataGridResult;
import com.shopping.pojo.ShoppingResult;
import com.shopping.pojo.TbItem;
import com.shopping.pojo.TbItemDesc;
import com.shopping.pojo.TbItemExample;
import com.shopping.pojo.TbItemParamItem;
import com.shopping.service.ItemService;
import com.shopping.utils.ExceptionUtil;
import com.shopping.utils.IDUtils;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	public TbItemMapper itemMapper;

	@Autowired
	public TbItemDescMapper itemDescMapper;

	@Autowired
	public TbItemParamItemMapper itemParamItemMapper;

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

	@Override
	public ShoppingResult addItem(TbItem item, TbItemDesc itemDesc, String itemParams) {
		try {
			long itemId = IDUtils.genItemId();
			item.setId(itemId);
			item.setStatus((byte) 1);
			Date date = new Date();
			item.setCreated(date);
			item.setUpdated(date);

			itemMapper.insert(item);

			itemDesc.setItemId(itemId);
			itemDesc.setCreated(date);
			itemDesc.setUpdated(date);

			itemDescMapper.insert(itemDesc);
			
			insertItemParamItem(itemId, itemParams);
		} catch (Exception e) {
			e.printStackTrace();
			return ShoppingResult.build(500, ExceptionUtil.getStackTrace(e));
		}

		return ShoppingResult.ok();
	}

	private ShoppingResult insertItemParamItem(Long itemId, String itemParams) {
		TbItemParamItem itemParamItem = new TbItemParamItem();

		itemParamItem.setItemId(itemId);
		itemParamItem.setParamData(itemParams);
		itemParamItem.setCreated(new Date());
		itemParamItem.setUpdated(new Date());
		
		itemParamItemMapper.insert(itemParamItem);
		
		return ShoppingResult.ok();
	}

}
