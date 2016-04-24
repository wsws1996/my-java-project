package org.wang.elec.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static String dateToStringByFile(Date date) {
		String sDate = new SimpleDateFormat(File.separator + "yyyy"
				+ File.separator + "MM" + File.separator + "dd"
				+ File.separator).format(date);
		return sDate;
	}

	public static String dateToString(Date date) {
		String sDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		return sDate;
	}
}
