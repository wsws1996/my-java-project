package cn.wang.service;

import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import cn.wang.dao.BookDao;
import cn.wang.domain.Book;
import cn.wang.domain.Cart;
import cn.wang.domain.CartItem;
import cn.wang.exception.CartNotFoundException;

public class BusinessService {
	BookDao dao = new BookDao();

	public Map getAllBook() {
		return dao.getAll();
	}

	public void buybook(String bookid, Cart cart) {
		// TODO Auto-generated method stub
		Book book = dao.find(bookid);
		cart.add(book);
	}

	public void deleteBook(String bookid, Cart cart)
			throws CartNotFoundException {
		// TODO Auto-generated method stub
		if (cart == null) {
			throw new CartNotFoundException("购物车为空！！！");
		}
		cart.getMap().remove(bookid);
	}

	public void clearCart() {
		// TODO Auto-generated method stub

	}

	public void clearCart(Cart cart) throws CartNotFoundException {
		// TODO Auto-generated method stub
		if (cart == null) {
			throw new CartNotFoundException("购物车为空！！！");
		}
		cart.getMap().clear();

	}

	public void updateCart(Cart cart, String bookid, int quantity)
			throws CartNotFoundException {
		// TODO Auto-generated method stub
		if (cart == null) {
			throw new CartNotFoundException("购物车为空！！！");
		}
		CartItem item = cart.getMap().get(bookid);
		item.setQuantity(quantity);
	}
}
