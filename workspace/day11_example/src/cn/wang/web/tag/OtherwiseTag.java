package cn.wang.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class OtherwiseTag extends SimpleTagSupport {

	public OtherwiseTag() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		ChooseTag parent = (ChooseTag) this.getParent();
		if (parent.isOk() == false) {
			this.getJspBody().invoke(null);
			parent.setOk(true);
		}
	}

}
