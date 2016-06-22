package com.wang.ws.webxml.client;

import java.util.List;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.WeatherWebService;
import cn.com.webxml.WeatherWebServiceSoap;

public class WeatherClient1 {
	public static void main(String[] args) {
		WeatherWebService weatherWebService = new WeatherWebService();
		WeatherWebServiceSoap weatherWebServiceSoap = weatherWebService.getWeatherWebServiceSoap();
		ArrayOfString arrayOfString = weatherWebServiceSoap.getWeatherbyCityName("濮阳");
		List<String> results= arrayOfString.getString();
		for (String result : results) {
			System.out.println(result);
		}
	}
}
