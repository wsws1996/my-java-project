package org.wang.elec.utils;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	/**将日期类型转换成String类型，file的格式*/
	public static String dateToStringByFile(Date date) {
		String sDate = new SimpleDateFormat(File.separator + "yyyy"
				+ File.separator + "MM" + File.separator + "dd"
				+ File.separator).format(date);
		return sDate;
	}
	
	/**将日期类型转换成String类型，yyyy-MM-dd HH:mm:ss的格式*/
	public static String dateToString(Date date) {
		String sDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		return sDate;
	}
	
	/**将日期类型转换成String类型，yyyyMMddHHmmss的格式*/
	public static String dateToStringWithExcel(Date date) {
		String sDate = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
		return sDate;
	}

	/**将String类型转换成日期类型，yyyy-MM-dd的格式
	 * @throws ParseException */
	public static Date stringToDate(String sDate) throws ParseException {
		Date date=null;
		date=new SimpleDateFormat("yyyy-MM-dd").parse(sDate);
		return date;
	}
}
