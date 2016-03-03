package junit.test;

import java.sql.SQLException;

import org.junit.Test;

import cn.wang.service.AccountService;

public class AccountServiceTest {
	
	@Test
	public void testTransfer() throws SQLException {
		AccountService service = new AccountService();
		service.transfer(1, 2, 100);
	}
}
