package com.wang.ws;

import javax.xml.ws.Endpoint;

import com.wang.ws.service.WeatherInterfaceImpl;

public class WeatherServer {

	public static void main(String[] args) {
		Endpoint.publish("http://127.0.0.1:12345/weather", new WeatherInterfaceImpl());
	}

}
