package com.shopping.service;

import com.shopping.pojo.EUDataGridResult;
import com.shopping.pojo.TbItemParam;
import com.shopping.result.ShoppingResult;

public interface ItemParamService {
	public ShoppingResult getItemParamByCid(long cid);

	public ShoppingResult insertItemParam(TbItemParam itemParam);

	
	public EUDataGridResult getItemParamList(Integer page,Integer rows);
}
