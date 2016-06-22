package com.wang.mybatis.po;


public class Items {
	private int id;//商品id
	private String item_name;//商品名称
	private Float item_price;//商品价格
	private String item_detail;//商品明细
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public Float getItem_price() {
		return item_price;
	}
	public void setItem_price(Float item_price) {
		this.item_price = item_price;
	}
	public String getItem_detail() {
		return item_detail;
	}
	public void setItem_detail(String item_detail) {
		this.item_detail = item_detail;
	}
	
	
}
