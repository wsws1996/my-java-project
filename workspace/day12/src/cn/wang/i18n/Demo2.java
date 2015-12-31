package cn.wang.i18n;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class Demo2 {

	public Demo2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL,
				Locale.GERMAN);
		String result = dateFormat.format(date);
		System.out.println(result);
		dateFormat = DateFormat.getTimeInstance(DateFormat.FULL, Locale.CHINA);
		result = dateFormat.format(date);
		System.out.println(result);
		dateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT,
				DateFormat.LONG, Locale.CHINA);
		System.out.println(dateFormat.format(date));
		String s = "15-12-6 下午03时39分10秒";
		dateFormat =DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG,Locale.CHINA);
		Date date2= dateFormat.parse(s);
		System.out.println(date2);
	}

}
