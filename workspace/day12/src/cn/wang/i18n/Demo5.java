package cn.wang.i18n;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.enterprise.inject.New;

public class Demo5 {

	public Demo5() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String pattern = "At {0,time,short} on {0,date},a destroyed {1} houses and caused{2,number,currency} of damage";
		MessageFormat format = new MessageFormat(pattern, Locale.US);
		Object arr = new Object[] { new Date(), 99, 1000000 };
		String result = format.format(arr);
		System.out.println(result);
		ResourceBundle bundle = ResourceBundle.getBundle(
				"cn.wang.resourse.myproperties", Locale.CHINA);
		pattern = bundle.getString("message");
		format = new MessageFormat(pattern, Locale.CHINA);
		arr = new Object[] { new Date(), 99, 1000000 };
		result = format.format(arr);
		System.out.println(result);
	}
}