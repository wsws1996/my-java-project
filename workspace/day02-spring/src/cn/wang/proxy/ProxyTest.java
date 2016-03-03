package cn.wang.proxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ProxyTest {
	@Test
	public void testProxy() {
		PersonDaoImpl target = new PersonDaoImpl();

		Transaction transaction=new Transaction();
		
		MyInterceptor myInterceptor=new MyInterceptor(target, transaction);
		PersonDaoImpl personDaoImpl=(PersonDaoImpl) myInterceptor.createProxy();
		personDaoImpl.updatePerson();
	}
}
