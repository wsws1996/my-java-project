package com.wang.ws.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.wang.ws.pojo.WeatherModel;

@WebService(targetNamespace = "http://weather.wang.com/", name = "WeatherInterface", portName = "WeatherInterfacePort", serviceName = "WeatherService")
public class WeatherInterfaceImpl implements WeatherInterface {

	//@WebMethod(operationName = "queryList")
	@Override
	public @WebResult(name = "result") List<WeatherModel> queryWeather(@WebParam(name = "cityName") String cityName) {

		List<WeatherModel> list = new ArrayList<WeatherModel>();

		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DATE);

		WeatherModel weatherModel_1 = new WeatherModel();
		weatherModel_1.setDetail("晴");
		weatherModel_1.setDate(new Date());
		weatherModel_1.setTemperature_max(29);
		weatherModel_1.setTemperature_min(17);
		WeatherModel weatherModel_2 = new WeatherModel();
		weatherModel_2.setDetail("阴");
		calendar.set(Calendar.DATE, day + 1);
		weatherModel_2.setDate(calendar.getTime());
		weatherModel_2.setTemperature_max(24);
		weatherModel_2.setTemperature_min(12);
		WeatherModel weatherModel_3 = new WeatherModel();
		weatherModel_3.setDetail("雨");
		calendar.set(Calendar.DATE, day + 2);
		weatherModel_3.setDate(calendar.getTime());
		weatherModel_3.setTemperature_max(20);
		weatherModel_3.setTemperature_min(5);

		list.add(weatherModel_1);
		list.add(weatherModel_2);
		list.add(weatherModel_3);

		return list;
	}

	// @Override
	// public void test() {
	// // TODO Auto-generated method stub
	//
	// }

}
