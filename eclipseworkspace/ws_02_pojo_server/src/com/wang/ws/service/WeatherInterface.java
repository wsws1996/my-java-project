package com.wang.ws.service;

import java.util.List;

import com.wang.ws.pojo.WeatherModel;

/**
 * 天气查询
 * 
 * @author wang
 *
 */
public interface WeatherInterface {
	public List<WeatherModel> queryWeather(String cityName);
}
