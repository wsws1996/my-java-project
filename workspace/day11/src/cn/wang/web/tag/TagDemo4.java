package cn.wang.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class TagDemo4 extends BodyTagSupport {

	public TagDemo4() {
	}

	@Override
	public int doEndTag() throws JspException {
		String content = this.getBodyContent().getString();
		String result = content.toUpperCase();
		try {
			this.pageContext.getOut().write(result);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return TagDemo1.EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		return BodyTag.EVAL_BODY_BUFFERED;
	}

}
