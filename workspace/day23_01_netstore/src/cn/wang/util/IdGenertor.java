package cn.wang.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class IdGenertor {
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}

	public static String genOrdernum() {
		Date now = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String s1 = dateFormat.format(now);
		return s1 + System.nanoTime();
	}
}
