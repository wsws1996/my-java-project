package cn.wang.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class WhenTag extends SimpleTagSupport {

	private boolean test;

	public void setTest(boolean test) {
		this.test = test;
	}

	public WhenTag() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		ChooseTag parent= (ChooseTag) this.getParent();
		if (test ==true && parent.isOk()==false) {
			this.getJspBody().invoke(null);
			parent.setOk(true);
		}
	}
}
