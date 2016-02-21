package cn.wang.action;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class Demo2Action extends ActionSupport {

	@Override
	public String execute() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		actionContext.put("p1", "p1value");
		String s1 = (String) actionContext.get("p1");
		System.out.println(s1);
		ValueStack valueStack = actionContext.getValueStack();
		System.out.println(valueStack);
		@SuppressWarnings("unchecked")
		Map<String, Object> requestAttributes = (Map<String, Object>) actionContext
				.get("request");
		ValueStack valueStack2 = (ValueStack) requestAttributes.get("struts.valueStack");
		System.out.println(valueStack2);
		System.out.println(actionContext.get(ValueStack.VALUE_STACK));
		HttpSession session= ServletActionContext.getRequest().getSession();
		session.setAttribute("p2", "p2value");
		String s2=(String) actionContext.getSession().get("p2");
		System.out.println(s2);
		String s3[]=(String []) actionContext.getParameters().get("name");
		System.out.println(Arrays.asList(s3));
		System.out.println(actionContext.getName());
		ServletContext servletContext=ServletActionContext.getServletContext();
		servletContext.setAttribute("p3", "p3value");
		System.out.println(actionContext.getApplication().get("p3"));
		return SUCCESS;
	}
}
