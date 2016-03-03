package cn.wang.proxy.salary;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInterceptor implements InvocationHandler {
	private Object target;
	private Logger logger;
	private Security security;
	private Privilege privilege;

	public MyInterceptor(Object target, Logger logger, Security security,
			Privilege privilege) {
		super();
		this.target = target;
		this.logger = logger;
		this.security = security;
		this.privilege = privilege;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		this.logger.logging();
		this.security.security();
		if ("admin".equals(this.privilege.getAccess())) {
			method.invoke(target);
		}else {
			System.out.println("error! access deined");
		}

		return null;
	}

}
