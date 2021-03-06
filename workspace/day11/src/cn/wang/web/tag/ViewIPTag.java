package cn.wang.web.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class ViewIPTag implements Tag {

	private PageContext pageContext = null;

	public ViewIPTag() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
		JspWriter out = pageContext.getOut();
		try {
			out.write("标签结束");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return 0;
	}

	@Override
	public int doStartTag() throws JspException {
		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
		JspWriter out = pageContext.getOut();
		String ip = request.getRemoteAddr();
		try {
			out.write(ip);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

	@Override
	public Tag getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPageContext(PageContext arg0) {
		this.pageContext = arg0;
	}

	@Override
	public void setParent(Tag arg0) {
		// TODO Auto-generated method stub

	}

}
