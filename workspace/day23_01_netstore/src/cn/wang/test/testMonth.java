package cn.wang.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class testMonth {
	@Test
	public void Month(){
		Date date=new Date();
		DateFormat dateFormat=new SimpleDateFormat("yyyymmdd");
		DateFormat dateFormat2=new SimpleDateFormat("yyyyMMdd");
		System.out.println(dateFormat.format(date));
		System.out.println(dateFormat2.format(date));
	}
}
