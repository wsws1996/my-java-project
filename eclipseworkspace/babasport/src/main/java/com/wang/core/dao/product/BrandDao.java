package com.wang.core.dao.product;

import java.util.List;

import com.wang.core.bean.product.Brand;
import com.wang.core.query.BrandQuery;

/**
 * 品牌
 * 
 * @author wang
 *
 */
public interface BrandDao {
	// List集合 limit 0,5
	public List<Brand> getBrandListWithPage(Brand brand);

	// 查询集合
	public List<Brand> getBrandList(BrandQuery brandQuery);
	
	// 查询总记录数
	public int getBrandCount(Brand brand);

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
