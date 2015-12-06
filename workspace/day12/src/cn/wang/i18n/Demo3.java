package cn.wang.i18n;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Demo3 {

	public Demo3() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws ParseException {
		int price = 89;
		NumberFormat numberFormat = NumberFormat
				.getCurrencyInstance(Locale.CHINA);
		String result = numberFormat.format(price);
		System.out.println(result);
		String s = "￥89.00";
		Number number = numberFormat.parse(s);
		System.out.println(number.doubleValue() + 1);
		double num = 0.5;
		numberFormat = NumberFormat.getPercentInstance();
		System.out.println(numberFormat.format(num));
	}
	
}