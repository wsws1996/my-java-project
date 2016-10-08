package com.wang.core.dao.product;

import java.util.List;

import com.wang.core.bean.product.Brand;

/**
 * 品牌
 * 
 * @author wang
 *
 */
public interface BrandDao {
	// List集合
	public List<Brand> getBrandListWithPage(Brand brand);

	// 查询总记录数
	public int getBrandCount(Brand brand);
	
	//添加品牌
	public void addBrand(Brand brand);
}
