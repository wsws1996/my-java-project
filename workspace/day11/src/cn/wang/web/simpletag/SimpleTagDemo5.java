package cn.wang.web.simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagDemo5 extends SimpleTagSupport {

	private int count;
	
	public void setCount(int count) {
		this.count = count;
	}

	public SimpleTagDemo5() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		for (int i = 0; i < count; i++) {
			this.getJspBody().invoke(null);
		}
	}
	
}
