package com.wang.ws.jaxws.weather.server;

import javax.jws.WebService;
import javax.xml.ws.BindingType;

@WebService
@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class WeatherInterfaceImpl implements WeatherInterface {

	@Override
	public String queryWeather(String cityName) {
		System.out.println("from client..." + cityName);
		String result = "晴";
		System.out.println("to client..." + result);
		return result;
	}

}
