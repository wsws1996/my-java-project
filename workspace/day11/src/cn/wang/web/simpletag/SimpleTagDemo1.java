package cn.wang.web.simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagDemo1 extends SimpleTagSupport {

	public SimpleTagDemo1() {
		// TODO Auto-generated constructor stub

	}

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		JspFragment jf = this.getJspBody();
//		jf.invoke(null);
	}

}
