package cn.wang.web.simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagDemo2 extends SimpleTagSupport {

	public SimpleTagDemo2() {
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		JspFragment jspFragment= this.getJspBody();
		for (int i = 0; i < 10; i++) {
			jspFragment.invoke(null);
		}
	}

}
