package com.wang.weather.client;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.wang.weather.WeatherInterface;
import com.wang.weather.WeatherModel;

public class WeatherClient {

	public static void main(String[] args) {
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
		jaxWsProxyFactoryBean.setAddress("http://127.0.0.1:12345/weather?wsdl");
		jaxWsProxyFactoryBean.setServiceClass(WeatherInterface.class);
		WeatherInterface weatherInterface = (WeatherInterface) jaxWsProxyFactoryBean.create();

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
