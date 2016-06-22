package com.wang.purchasing.vo;

public class OrderVo {
	private OrderCustom orderCustom;

	private OrderAuditCustom orderAuditCustom;

	public OrderAuditCustom getOrderAuditCustom() {
		return orderAuditCustom;
	}

	public void setOrderAuditCustom(OrderAuditCustom orderAuditCustom) {
		this.orderAuditCustom = orderAuditCustom;
	}

	public OrderCustom getOrderCustom() {
		return orderCustom;
	}

	public void setOrderCustom(OrderCustom orderCustom) {
		this.orderCustom = orderCustom;
	}

}
