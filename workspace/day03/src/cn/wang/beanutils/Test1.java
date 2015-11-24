package cn.wang.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class Test1 {

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		String birthday="1980-09-09";
		Student s=new Student();
		ConvertUtils.register(/*new Converter() {
			
			@Override
			public <T> T convert(Class<T> type, Object value) {
				// TODO Auto-generated method stub
				if (value==null) {
					return null;
				}
				SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd");
				Date date=null;
				try {
					date= format.parse((String) value);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					throw new ConversionException(e);
				}
				return (T) date;
			}
		}*/new DateLocaleConverter(), Date.class);
		BeanUtils.setProperty(s, "birthday", birthday);
		System.out.println(s.getBirthday());
	}

}
