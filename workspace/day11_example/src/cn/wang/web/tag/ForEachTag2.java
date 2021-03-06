package cn.wang.web.tag;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForEachTag2 extends SimpleTagSupport {

	private Object items;
	private String var; 
	private Collection collection;

	public void setItems(Object items) {
		this.items = items;
		if (items instanceof Collection) {
			collection = (Collection) items;

		}
		if (items instanceof Map) {
			Map map = (Map) items;
			collection = map.entrySet();
		}
		if (items.getClass().isArray()) {
			collection=new ArrayList();
			int len =Array.getLength(items);
			for (int i = 0; i < len; i++) {
				Object object=Array.get(items, i);
				collection.add(object);
			}
		}
	}

	public void setVar(String var) {
		this.var = var;
	}

	public ForEachTag2() {
	}

	@Override
	public void doTag() throws JspException, IOException {

		PageContext pageContext = (PageContext) this.getJspContext();
		Iterator iterator = collection.iterator();
		while (iterator.hasNext()) {
			Object object = iterator.next();
			pageContext.setAttribute(var, object);
			this.getJspBody().invoke(null);
		}
	}

}
