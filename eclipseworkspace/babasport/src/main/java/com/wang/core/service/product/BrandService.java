package com.wang.core.service.product;

import com.wang.core.bean.product.Brand;

import cn.itcast.common.page.Pagination;

/**
 * 品牌
 * @author wang
 *
 */
public interface BrandService {
	public Pagination getBrandListWithPage(Brand brand);
	
	//添加品牌
	public void addBrand(Brand brand);
}
