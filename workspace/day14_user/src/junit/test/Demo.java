package junit.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class Demo {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		String birthday = "1980-12-30";
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
//		Date date=sdf.parse(birthday);
//		System.out.println(date);
		DateLocaleConverter converter=new DateLocaleConverter();
		Date date=(Date) converter.convert(birthday);
		System.out.println(date);
	}

}
