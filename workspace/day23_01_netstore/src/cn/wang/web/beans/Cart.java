package cn.wang.web.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.wang.domain.Book;

public class Cart implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6649527532710000324L;
	// key：对应书的id
	private Map<String, CartItem> items = new HashMap<String, CartItem>();
	private int totalQuntity;// 总数量
	private float totalMoney;// 总金额

	public int getTotalQuntity() {
		totalQuntity = 0;
		for (Map.Entry<String, CartItem> me : items.entrySet()) {
			totalQuntity += me.getValue().getQuantity();
		}
		return totalQuntity;
	}

	public void setTotalQuntity(int totalQuntity) {
		this.totalQuntity = totalQuntity;
	}

	public float getTotalMoney() {
		totalMoney = 0;
		for (Map.Entry<String, CartItem> me : items.entrySet()) {
			totalMoney += me.getValue().getMoney();
		}
		return totalMoney;
	}

	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Map<String, CartItem> getItems() {
		return items;
	}

	// 向购物车中添加一本书
	public void addBook(Book book) {
		if (items.containsKey(book.getId())) {
			CartItem item = items.get(book.getId());
			item.setQuantity(item.getQuantity() + 1);
		} else {
			CartItem item = new CartItem(book);
			item.setQuantity(1);
			items.put(book.getId(), item);
		}
	}
}
