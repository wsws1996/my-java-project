package com.wang.core.controller.admin;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wang.core.bean.product.Brand;
import com.wang.core.service.product.BrandService;

import cn.itcast.common.page.Pagination;

/**
 * 品牌
 * 
 * @author wang
 *
 */
@Controller
public class BrandController {

	@Autowired
	private BrandService brandService;

	// 品牌列表页面
	@RequestMapping(value = "/brand/list.do")
	public String list(String name, Integer isDisplay, Integer pageNo,ModelMap model) {
		Brand brand = new Brand();
		// 判断传进来的名称是否为null并判断是否为空串
		if (null != name && StringUtils.isNotBlank(name)) {
			brand.setName(name);
		}
		brand.setIsDisplay(isDisplay);

		// 页号
		//如果页号为null或小于1，置为1
		brand.setPageNo(Pagination.cpn(pageNo));
		//分页对象
		Pagination pagination = brandService.getBrandListWithPage(brand);
		model.addAttribute("pagination", pagination);
		return "brand/list";
	}
}
