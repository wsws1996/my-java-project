package com.shopping.service;

import com.shopping.pojo.ShoppingResult;

public interface ItemService {

	public ShoppingResult getItemBaseInfo(long itemId);

	public ShoppingResult getItemDesc(long itemId);

	public ShoppingResult getItemParam(long itemId);
}
