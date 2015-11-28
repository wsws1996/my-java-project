package cn.wang.web.simpletag;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagDemo3 extends SimpleTagSupport {

	public SimpleTagDemo3() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		JspFragment jspFragment = this.getJspBody();
		StringWriter stringWriter = new StringWriter();
		jspFragment.invoke(stringWriter);
		String contentString = stringWriter.getBuffer().toString();
		contentString = contentString.toUpperCase();
		PageContext pageContext = (PageContext) this.getJspContext();
		pageContext.getOut().write(contentString);
	}

}
