package com.wang.ws.jaxws.weather.client;

import com.wang.ws.jaxws.weather.server.WeatherInterfaceImpl;
import com.wang.ws.jaxws.weather.server.WeatherInterfaceImplService;

public class WeatherClient {
	public static void main(String[] args) {
		WeatherInterfaceImplService weatherInterfaceImplService = new WeatherInterfaceImplService();
		WeatherInterfaceImpl weatherInterfaceImpl=weatherInterfaceImplService.getWeatherInterfaceImplPort();
		 String result= weatherInterfaceImpl.queryWeather("郑州");
		 System.out.println(result);
	}
}
