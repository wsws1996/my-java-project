package cn.wang.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class TagDemo1 extends TagSupport {

	public TagDemo1() {
	}

	@Override
	public int doStartTag() throws JspException {
		
		return Tag.SKIP_BODY;
	}
	
	
}
