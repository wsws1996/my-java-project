package com.wang.ws.webxml.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;


import cn.com.webxml.ArrayOfString;
import cn.com.webxml.WeatherWebServiceSoap;

public class WeatherClient2 {

	public static void main(String[] args) throws MalformedURLException {
		URL wsdlDocumentLocation = new URL("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl");

		QName serviceName = new QName("http://WebXml.com.cn/", "WeatherWebService");

		Service service = Service.create(wsdlDocumentLocation, serviceName);

		WeatherWebServiceSoap weatherInterfaceImpl = service.getPort(WeatherWebServiceSoap.class);
		ArrayOfString arrayOfString = weatherInterfaceImpl.getWeatherbyCityName("上海");
		List<String> results = arrayOfString.getString();
		for (String result : results) {
			System.out.println(result);
		}
	}

}
