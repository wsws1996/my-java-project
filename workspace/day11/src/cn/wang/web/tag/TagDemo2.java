package cn.wang.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class TagDemo2 extends TagSupport {

	public TagDemo2() {
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return Tag.EVAL_PAGE;
	}

}
