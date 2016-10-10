package com.wang.core.service.product;

import java.util.List;

import com.wang.core.bean.product.Brand;
import com.wang.core.query.product.BrandQuery;

import cn.itcast.common.page.Pagination;

/**
 * 品牌
 * 
 * @author wang
 *
 */
public interface BrandService {
	public Pagination getBrandListWithPage(Brand brand);

	// 查询集合
	public List<Brand> getBrandList(BrandQuery brandQuery);

	// 添加品牌
	public void addBrand(Brand brand);

	// 删除
	public void deleteBrandByKey(Integer id);

	// 删除批量
	public void deleteBrandByKeys(Integer[] ids);

	// 修改
	public void updateBrandByKey(Brand brand);

	public Brand getBrandByKey(Integer id);
}
