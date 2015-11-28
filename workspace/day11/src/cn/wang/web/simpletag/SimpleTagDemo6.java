package cn.wang.web.simpletag;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagDemo6 extends SimpleTagSupport {

	private Date date;

	public void setDate(Date date) {
		this.date = date;
	}

	public SimpleTagDemo6() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		System.out.println(date);
	}

}
