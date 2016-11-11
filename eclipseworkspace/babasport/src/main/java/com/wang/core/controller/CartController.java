package com.wang.core.controller;

import java.io.StringWriter;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wang.common.web.session.SessionProvider;
import com.wang.core.bean.BuyCart;
import com.wang.core.bean.BuyItem;
import com.wang.core.bean.product.Sku;
import com.wang.core.bean.user.Addr;
import com.wang.core.bean.user.Buyer;
import com.wang.core.query.user.AddrQuery;
import com.wang.core.service.product.SkuService;
import com.wang.core.service.user.AddrService;
import com.wang.core.web.Constants;

/**
 * 购物车
 * 
 * @author wang
 *
 */
@Controller
public class CartController {
	@RequestMapping(value = "/shopping/buyCart.shtml")
	public String buyCart(Integer skuId, Integer amount, Integer buyLimit, Integer productId,
			HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		ObjectMapper om = new ObjectMapper();
		om.setSerializationInclusion(Inclusion.NON_NULL);
		// 声明
		BuyCart buyCart = null;
		// 判断Cookie是否有购物车
		Cookie[] cookies = request.getCookies();
		if (null != cookies && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (Constants.BUYCART_COOKIE.equals(cookie.getName())) {
					// 如果有了 就使用此购物车
					String value = cookie.getValue();
					try {
						buyCart = om.readValue(value, BuyCart.class);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
		if (null == buyCart) {
			// 如果没有 创建购物车
			buyCart = new BuyCart();
		}
		if (null != skuId) {
			Sku sku = new Sku();
			sku.setId(skuId);
			// 购买限制
			if (null != buyLimit) {
				sku.setSkuUpperLimit(buyLimit);
			}
			// 创建购物项
			BuyItem buyItem = new BuyItem();
			buyItem.setSku(sku);
			// 数量
			buyItem.setAmount(amount);
			// 添加购物项
			buyCart.addItem(buyItem);
			// 最后一款商品的ID
			if (null != productId) {
				buyCart.setProductId(productId);
			}

			// 流
			StringWriter str = new StringWriter();

			try {
				om.writeValue(str, buyCart);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 将购物车装进Cookie中
			Cookie cookie = new Cookie(Constants.BUYCART_COOKIE, str.toString());
			// 关闭浏览器 也要有Cookie
			// 默认是-1 关闭浏览器就不存在了
			// 销毁 0 立即销毁
			// expiry 单位：秒
			cookie.setMaxAge(60 * 60 * 24);
			// 路径
			/// shopping/buyCart.shtml
			// 默认 /shopping
			cookie.setPath("/");
			// 发送
			response.addCookie(cookie);

		}
		// 填充购物车信息
		List<BuyItem> items = buyCart.getItems();
		for (BuyItem item : items) {
			Sku s = skuService.getSkuByKey(item.getSku().getId());
			item.setSku(s);
		}
		model.addAttribute("buyCart", buyCart);

		return "product/cart";
	}

	@RequestMapping(value = "/shopping/clearCart.shtml")
	public String clearCart(HttpServletRequest request, HttpServletResponse response) {
		Cookie cookie = new Cookie(Constants.BUYCART_COOKIE, null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		return "redirect:/shopping/buyCart.shtml";
	}

	@RequestMapping(value = "/shopping/deleteItem.shtml")
	public String deleteItem(HttpServletRequest request, Integer skuId, HttpServletResponse response) {
		ObjectMapper om = new ObjectMapper();
		om.setSerializationInclusion(Inclusion.NON_NULL);
		// 声明
		BuyCart buyCart = null;
		// 判断Cookie是否有购物车
		Cookie[] cookies = request.getCookies();
		if (null != cookies && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (Constants.BUYCART_COOKIE.equals(cookie.getName())) {
					// 如果有了 就使用此购物车
					String value = cookie.getValue();
					try {
						buyCart = om.readValue(value, BuyCart.class);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
		if (null != buyCart) {
			Sku sku = new Sku();
			sku.setId(skuId);
			// 创建购物项
			BuyItem buyItem = new BuyItem();
			buyItem.setSku(sku);

			buyCart.deleteItem(buyItem);
			// 流
			StringWriter str = new StringWriter();

			try {
				om.writeValue(str, buyCart);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 将购物车装进Cookie中
			Cookie cookie = new Cookie(Constants.BUYCART_COOKIE, str.toString());
			// 关闭浏览器 也要有Cookie
			// 默认是-1 关闭浏览器就不存在了
			// 销毁 0 立即销毁
			// expiry 单位：秒
			cookie.setMaxAge(60 * 60 * 24);
			// 路径
			/// shopping/buyCart.shtml
			// 默认 /shopping
			cookie.setPath("/");
			// 发送
			response.addCookie(cookie);
		}
		return "redirect:/shopping/buyCart.shtml";
	}
	@RequestMapping("/buyer/trueBuy.shtml")
	public String trueBuy(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		ObjectMapper om = new ObjectMapper();
		om.setSerializationInclusion(Inclusion.NON_NULL);
		// 声明
		BuyCart buyCart = null;
		// 判断Cookie是否有购物车
		Cookie[] cookies = request.getCookies();
		if (null != cookies && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (Constants.BUYCART_COOKIE.equals(cookie.getName())) {
					// 如果有了 就使用此购物车
					String value = cookie.getValue();
					try {
						buyCart = om.readValue(value, BuyCart.class);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
		if (null != buyCart) {
			List<BuyItem> items = buyCart.getItems();
			if (null != items && items.size() > 0) {
				// 判断购物车中的商品是否还有库存

				// 购物车中的商品项
				Integer i = items.size();

				for (BuyItem it : items) {
					Sku sku = skuService.getSkuByKey(it.getSku().getId());
					// 判断库存
					if (sku.getStockInventory() < it.getAmount()) {
						// 删除此商品
						buyCart.deleteItem(it);
					}
				}
				// 清理后商品项的个数
				Integer l = items.size();
				// 判断清理前后
				if (i > l) {
					// 修改Cookie中的购物车数据

					// 流
					StringWriter str = new StringWriter();

					try {
						om.writeValue(str, buyCart);
					} catch (Exception e) {
						e.printStackTrace();
					}
					// 将购物车装进Cookie中
					Cookie cookie = new Cookie(Constants.BUYCART_COOKIE, str.toString());
					// 关闭浏览器 也要有Cookie
					// 默认是-1 关闭浏览器就不存在了
					// 销毁 0 立即销毁
					// expiry 单位：秒
					cookie.setMaxAge(60 * 60 * 24);
					// 路径
					/// shopping/buyCart.shtml
					// 默认 /shopping
					cookie.setPath("/");
					// 发送
					response.addCookie(cookie);

					return "redirect:/shopping/buyCart.shtml";
				} else {
					// 收货地址加载
					Buyer buyer = (Buyer) sessionProvider.getAttribute(request, response, Constants.BUYER_SESSION);
					AddrQuery addrQuery = new AddrQuery();
					addrQuery.setBuyerId(buyer.getUsername());
					// 默认是1
					addrQuery.setIsDef(1);
					List<Addr> addrs = addrService.getAddrList(addrQuery);
					model.addAttribute("addr", addrs.get(0));
					
					// 填充购物车信息
					List<BuyItem> its = buyCart.getItems();
					for (BuyItem item : its) {
						Sku s = skuService.getSkuByKey(item.getSku().getId());
						item.setSku(s);
					}
					model.addAttribute("buyCart", buyCart);
					
					// 正常
					return "product/productOrder";
				}
			} else {
				return "redirect:/shopping/buyCart.shtml";
			}
		} else {
			return "redirect:/shopping/buyCart.shtml";
		}

	}

	@Autowired
	private SkuService skuService;
	@Autowired
	private AddrService addrService;
	@Autowired
	private SessionProvider sessionProvider;
}
