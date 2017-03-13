package com.shopping.service;

import com.shopping.pojo.EUDataGridResult;
import com.shopping.pojo.ShoppingResult;
import com.shopping.pojo.TbItemParam;

public interface ItemParamService {
	public ShoppingResult getItemParamByCid(long cid);

	public ShoppingResult insertItemParam(TbItemParam itemParam);

	
	public EUDataGridResult getItemParamList(Integer page,Integer rows);
}
