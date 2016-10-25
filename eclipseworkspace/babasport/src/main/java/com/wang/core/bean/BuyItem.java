package com.wang.core.bean;

import com.wang.core.bean.product.Sku;

/**
 * 购物项
 * 
 * @author wang
 *
 */
public class BuyItem {
	// Sku
	private Sku sku;
	// 数量
	private int amount = 1;

	public Sku getSku() {
		return sku;
	}

	public void setSku(Sku sku) {
		this.sku = sku;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
