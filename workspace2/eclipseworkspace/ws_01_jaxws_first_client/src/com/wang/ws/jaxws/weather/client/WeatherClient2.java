package com.wang.ws.jaxws.weather.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.wang.ws.jaxws.weather.server.WeatherInterfaceImpl;

public class WeatherClient2 {
	public static void main(String[] args) throws MalformedURLException {
		URL wsdlDocumentLocation = new URL("http://127.0.0.1:54321/weather?wsdl");

		QName serviceName = new QName("http://server.weather.jaxws.ws.wang.com/", "WeatherInterfaceImplService");

		Service service = Service.create(wsdlDocumentLocation, serviceName);

		WeatherInterfaceImpl weatherInterfaceImpl = service.getPort(WeatherInterfaceImpl.class);
		String result = weatherInterfaceImpl.queryWeather("北京");
		System.out.println(result);
	}
}
