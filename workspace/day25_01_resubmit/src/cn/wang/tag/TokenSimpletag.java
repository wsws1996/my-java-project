package cn.wang.tag;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TokenSimpletag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		//产生一个唯一的token
		//放到httpsession中一个：token
		//输出一个<input type="hidden" name="token" value=""/>
		String token=UUID.randomUUID().toString();
		PageContext pageContext=(PageContext) getJspContext();
		pageContext.getSession().setAttribute("token", token);
		pageContext.getOut().write("<input type=\"hidden\" name=\"token\" value=\""+token+"\"/>");
	}
}
