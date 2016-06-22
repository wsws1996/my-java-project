package com.wang.ws.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.BindingType;

import com.wang.ws.pojo.WeatherModel;

/**
 * 天气查询
 * 
 * @author wang
 *
 */
@WebService(targetNamespace = "http://weather.wang.com/", name = "WeatherInterface", portName = "WeatherInterfacePort", serviceName = "WeatherService")
@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public interface WeatherInterface {
	public @WebResult(name = "result") List<WeatherModel> queryWeather(@WebParam(name = "cityName") String cityName);
}
