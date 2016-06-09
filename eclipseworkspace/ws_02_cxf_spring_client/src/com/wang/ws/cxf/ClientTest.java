package com.wang.ws.cxf;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wang.weather.WeatherInterface;
import com.wang.weather.WeatherModel;

public class ClientTest {

	private ApplicationContext applicationContext;

	@Before
	public void before() {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Test
	public void testCxfSpringClient() {
		WeatherInterface weatherInterface = (WeatherInterface) applicationContext.getBean("weatherClient");
		List<WeatherModel> list = weatherInterface.queryWeather("北京");

		for (WeatherModel weatherModel : list) {
			System.out.println("----------------------");
			System.out.println(weatherModel.getDetail());
			Date date = weatherModel.getDate().toGregorianCalendar().getTime();
			System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
			System.out.println(weatherModel.getTemperatureMax());
			System.out.println(weatherModel.getTemperatureMin());
		}
	}
}
