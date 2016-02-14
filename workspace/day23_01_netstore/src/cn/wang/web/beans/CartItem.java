package cn.wang.web.beans;

import java.io.Serializable;

import cn.wang.domain.Book;

public class CartItem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6877223251330788313L;

	private Book book;
	private int quantity;
	private float money;

	public CartItem(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getMoney() {
		money = book.getPrice() * quantity;
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public Book getBook() {
		return book;
	}
}
