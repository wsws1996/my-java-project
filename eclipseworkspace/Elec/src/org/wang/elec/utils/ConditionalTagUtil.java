package org.wang.elec.utils;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.struts2.ServletActionContext;

public class ConditionalTagUtil extends SimpleTagSupport {
	
	private String pattern;
	
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}



	@Override
	public void doTag() throws JspException, IOException {
		String popedom = (String) ServletActionContext.getRequest()
				.getSession().getAttribute("globle_popedom");
		if (popedom.contains(pattern)) {
			this.getJspBody().invoke(null);
		}
	}
}
