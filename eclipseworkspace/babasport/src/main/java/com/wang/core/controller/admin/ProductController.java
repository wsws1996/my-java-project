package com.wang.core.controller.admin;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wang.core.bean.product.Brand;
import com.wang.core.query.product.BrandQuery;
import com.wang.core.query.product.ProductQuery;
import com.wang.core.service.product.BrandService;
import com.wang.core.service.product.ProductService;

import cn.itcast.common.page.Pagination;

/**
 * 后台商品管理 商品列表 商品添加 商品上架
 * 
 * @author wang
 *
 */
@Controller
public class ProductController {

	@Autowired
	private BrandService brandService;
	@Autowired
	private ProductService productService;

	// 商品列表
	@RequestMapping(value = "/product/list.do")
	public String list(Integer pageNo, String name, Integer brandId, Integer isShow, ModelMap model) {

		BrandQuery brandQuery = new BrandQuery();

		brandQuery.setFields("id,name");
		brandQuery.setIsDisplay(1);
		// 加载品牌
		List<Brand> brands = brandService.getBrandList(brandQuery);

		model.addAttribute("brands", brands);

		// 分页参数
		StringBuilder params = new StringBuilder();

		// 商品条件对象
		ProductQuery productQuery = new ProductQuery();
		// 判断条件是否为Null
		if (StringUtils.isNotBlank(name)) {
			productQuery.setName(name);
			// 要求模糊查询
			productQuery.setNameLike(true);
			params.append("&name=").append(name);

			// 回显查询条件
			model.addAttribute("name", name);
		}
		// 判断品牌ID
		if (null != brandId) {
			productQuery.setBrandId(brandId);
			params.append("&brandId=").append(brandId);

			// 回显查询条件
			model.addAttribute("brandId", brandId);
		}
		// 判断上下架状态
		if (null != isShow) {
			productQuery.setIsShow(isShow);
			params.append("&isShow=").append(isShow);

			// 回显查询条件
			model.addAttribute("isShow", isShow);
		} else {
			productQuery.setIsShow(0);
			params.append("&isShow=").append(0);
			// 回显查询条件
			model.addAttribute("isShow", 0);
		}
		// 设置页号
		productQuery.setPageNo(Pagination.cpn(pageNo));
		// 设置每页数
		productQuery.setPageSize(5);

		// 加载带有分页的商品
		Pagination pagination = productService.getProductListWithPage(productQuery);

		// 分页页面显示
		String url = "/product/list.do";
		pagination.pageView(url, params.toString());
		model.addAttribute("pagination", pagination);
		return "product/list";
	}
}
