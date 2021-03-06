package cn.wang.web.tag;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForEachTag extends SimpleTagSupport {
	private List items;
	private String var;

	public void setItems(List items) {
		this.items = items;
	}

	public void setVar(String var) {
		this.var = var;
	}

	@Override
	public void doTag() throws JspException, IOException {

		PageContext pageContext = (PageContext) this.getJspContext();
		Iterator iterator = items.iterator();
		while (iterator.hasNext()) {
			Object object = iterator.next();
			pageContext.setAttribute(var, object);
			this.getJspBody().invoke(null);
		}
	}

	public ForEachTag() {
		// TODO Auto-generated constructor stub
	}

}
