package cn.wang.i18n;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;

public class Demo4 {

	public Demo4() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String pattern = "On {0}, a hurricance destoryed {1} houses and caused {2} of demages";
		MessageFormat format = new MessageFormat(pattern, Locale.CHINA);
		Object arr[] = { new Date(), 99, 1000000 };
		String result = format.format(arr);
		System.out.println(result);
	}
}
