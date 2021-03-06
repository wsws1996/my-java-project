package com.shopping.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shopping.mapper.TbItemParamMapper;
import com.shopping.pojo.EUDataGridResult;
import com.shopping.pojo.ShoppingResult;
import com.shopping.pojo.TbItemParam;
import com.shopping.pojo.TbItemParamExample;
import com.shopping.pojo.TbItemParamExample.Criteria;
import com.shopping.service.ItemParamService;

@Service
public class ItemParamServiceImpl implements ItemParamService {

	@Autowired
	private TbItemParamMapper itemParamMapper;

	@Override
	public ShoppingResult getItemParamByCid(long cid) {

		TbItemParamExample example = new TbItemParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemCatIdEqualTo(cid);
		List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);

		if (list != null && list.size() > 0) {
			return ShoppingResult.ok(list.get(0));
		}

		return ShoppingResult.ok();
	}

	@Override
	public ShoppingResult insertItemParam(TbItemParam itemParam) {
		itemParam.setCreated(new Date());
		itemParam.setUpdated(new Date());

		itemParamMapper.insert(itemParam);

		return ShoppingResult.ok();
	}

	@Override
	public EUDataGridResult getItemParamList(Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(new TbItemParamExample());
		PageInfo<TbItemParam> pageInfo = new PageInfo<>(list);

		EUDataGridResult result = new EUDataGridResult(pageInfo.getTotal(), list);
		return result;

	}

}
