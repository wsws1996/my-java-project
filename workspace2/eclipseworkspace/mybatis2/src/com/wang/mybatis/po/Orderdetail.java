package com.wang.mybatis.po;


public class Orderdetail {
	private int id;//主键
	private int orders_id;//订单id
	private int item_id;//商品id
	private int item_num;//商品数量
	private Float item_price;//商品价格
	
	//商品信息
	private Items items;//明细对应的商品信息 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrders_id() {
		return orders_id;
	}
	public void setOrders_id(int orders_id) {
		this.orders_id = orders_id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}
	public Float getItem_price() {
		return item_price;
	}
	public void setItem_price(Float item_price) {
		this.item_price = item_price;
	}
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	
	
}
