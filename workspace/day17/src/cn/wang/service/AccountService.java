package cn.wang.service;

import java.sql.SQLException;

import cn.wang.dao.AccountDao;
import cn.wang.domain.Account;
import cn.wang.utils.JdbcUtil;

public class AccountService {

	public void transfer(int sourceid, int targetid, float money)
			throws SQLException {

		try {
			JdbcUtil.startTransaction();

			AccountDao dao = new AccountDao();

			Account source = dao.find(sourceid);
			Account target = dao.find(targetid);

			source.setMoney(source.getMoney() - money);
			target.setMoney(target.getMoney() + money);

			dao.update(source);

			int x = 1 / 0;

			dao.update(target);

			JdbcUtil.commit();

		} catch (Exception e) {
			e.printStackTrace();
			JdbcUtil.rollback();
		} finally {
			JdbcUtil.release();
		}
	}
}
