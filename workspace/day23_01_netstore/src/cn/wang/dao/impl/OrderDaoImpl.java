package cn.wang.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.wang.dao.OrderDao;
import cn.wang.domain.Order;
import cn.wang.domain.OrderItem;
import cn.wang.util.DBCPUtil;

public class OrderDaoImpl implements OrderDao {

	private QueryRunner queryRunner = new QueryRunner(DBCPUtil.getDataSource());

	@Override
	public void save(Order order) {
		try {
			queryRunner
					.update("insert into orders(ordernum,quantity,money,status,customerId) values(?,?,?,?,?)",
							order.getOrdernum(), order.getQuantity(), order
									.getMoney(), order.getStatus(), order
									.getCustomer().getId());
			List<OrderItem> items = order.getItems();
			for (OrderItem orderItem : items) {
				queryRunner
						.update("insert into orderitems (id,quantity,price,bookId,ordernum) value(?,?,?,?,?)",
								orderItem.getId(), orderItem.getQuantity(),
								orderItem.getPrice(), orderItem.getBook()
										.getId(), order.getOrdernum());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Order findByNum(String ordernum) {
		try {
			return queryRunner.query("select * from orders where ordernum=?",
					new BeanHandler<Order>(Order.class), ordernum);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Order> findByCustomer(String customerid) {
		try {
			return queryRunner
					.query("select * from orders where customerId=? order by ordernum desc",
							new BeanListHandler<Order>(Order.class), customerid);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateStatus(Order order) {
		try {
			queryRunner.update("update orders set status=? where ordernum=?",
					order.getStatus(), order.getOrdernum());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
