package com.shopping.service;

import com.shopping.pojo.EUDataGridResult;

public interface ItemService {
	public EUDataGridResult getItemList(int page, int rows);
}
