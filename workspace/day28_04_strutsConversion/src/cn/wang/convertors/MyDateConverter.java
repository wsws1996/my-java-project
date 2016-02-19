package cn.wang.convertors;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class MyDateConverter extends StrutsTypeConverter {

	private DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

	@Override
	public Object convertFromString(@SuppressWarnings("rawtypes") Map context,
			String[] values, @SuppressWarnings("rawtypes") Class toClass) {
		if (toClass != Date.class) {
			throw new RuntimeException("您转换的不是日期");
		}
		if (values == null || values.length == 0) {
			throw new IllegalArgumentException("没有数据");
		}
		String sDate = values[0];
		if (!sDate.trim().equals("")) {
			try {
				return dateFormat.parse(sDate);
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
		}
		return null;
	}

	@Override
	public String convertToString(@SuppressWarnings("rawtypes") Map context, Object o) {
		if (!(o instanceof Date)) {
			throw new RuntimeException("您的数据不是日期！");
		}
		return dateFormat.format((Date) o);
	}

}
