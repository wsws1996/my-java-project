package com.shopping.service;

import com.shopping.pojo.ItemInfo;

public interface ItemService {

	public ItemInfo getItemById(Long itemId);

	public String getItemDescById(Long itemId);

	public String getItemParamById(Long itemId);
}
