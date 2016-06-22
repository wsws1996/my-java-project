package com.wang.weather.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.wang.weather.WeatherInterface;
import com.wang.weather.WeatherModel;

public class WeatherClient2 {
	public static void main(String[] args) throws MalformedURLException {
		URL wsdlDocumentLocation = new URL("http://127.0.0.1:12345/weather?wsdl");

		QName serviceName = new QName("http://weather.wang.com/", "WeatherService");

		Service service = Service.create(wsdlDocumentLocation, serviceName);

		WeatherInterface weatherInterface = service.getPort(WeatherInterface.class);
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
