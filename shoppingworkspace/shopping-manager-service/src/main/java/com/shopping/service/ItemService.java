package com.shopping.service;

import com.shopping.pojo.EUDataGridResult;
import com.shopping.pojo.TbItem;
import com.shopping.pojo.TbItemDesc;
import com.shopping.result.ShoppingResult;

public interface ItemService {
	public EUDataGridResult getItemList(int page, int rows);

	public ShoppingResult addItem(TbItem item, TbItemDesc itemDesc);
}
