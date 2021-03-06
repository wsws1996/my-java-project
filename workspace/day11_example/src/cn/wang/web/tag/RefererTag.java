package cn.wang.web.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class RefererTag extends SimpleTagSupport {

	private String site;
	private String page;

	public void setSite(String site) {
		this.site = site;
	}

	public void setPage(String page) {
		this.page = page;
	}

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		PageContext pageContext = (PageContext) this.getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
		String referer = request.getHeader("referer");
		if (referer == null || !referer.startsWith(site)) {
			HttpServletResponse response = (HttpServletResponse) pageContext
					.getResponse();
			String webroot = request.getContextPath();
			if (page.startsWith(webroot)) {
				response.sendRedirect(page);
			} else {
				response.sendRedirect(webroot + page);
			}
			throw new SkipPageException();
		}

	}

	public RefererTag() {
		// TODO Auto-generated constructor stub
	}

}
