package cn.wang.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class IfTag extends SimpleTagSupport {

	private boolean test;
	
	
	public void setTest(boolean test) {
		this.test = test;
	}


	public IfTag() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		if (test) {
			this.getJspBody().invoke(null);
		}
	}

	
	
}
