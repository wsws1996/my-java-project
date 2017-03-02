package com.shopping.service;

import java.util.List;

import com.shopping.pojo.TbItemCat;

public interface ItemCatService {
	public List<TbItemCat> getItemCatList(Long parentId);
}
