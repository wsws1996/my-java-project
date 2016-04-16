package org.wang.elec.utils;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class ErrorAndLimitInterceptor extends MethodFilterInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8251584638156651158L;

	@Override
	protected String doIntercept(ActionInvocation actioninvocation)
			throws Exception {
		HttpServletRequest request = (HttpServletRequest) actioninvocation
				.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
		try {
			// 获取请求的action对象
			Object action = actioninvocation.getAction();
			// 获取请求的方法的名称
			String methodName = actioninvocation.getProxy().getMethod();
			// 获取action中的方法的封装类(action中的方法没有参数)
			Method method = action.getClass().getMethod(methodName, null);
			// Action的返回值
			String result = null;

			result = actioninvocation.invoke();

			return result;
		} catch (Exception e) {
			/**
			 * 处理异常
			 */
			String errorMsg = "出现错误信息，请查看日志！";
			// 通过instanceof判断到底是什么异常类型
			if (e instanceof RuntimeException) {
				// 未知的运行时异常
				RuntimeException re = (RuntimeException) e;
				// re.printStackTrace();
				errorMsg = re.getMessage().trim();
			}
			/**
			 * 发送错误消息到页面
			 */
			request.setAttribute("errorMsg", errorMsg);

			/**
			 * log4j记录日志
			 */
			Log log = LogFactory
					.getLog(actioninvocation.getAction().getClass());
			log.error(errorMsg, e);
			return "errorMsg";
		}
	}
}
