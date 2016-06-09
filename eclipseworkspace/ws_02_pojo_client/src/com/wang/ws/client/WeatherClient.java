package com.wang.ws.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.wang.ws.service.WeatherInterfaceImpl;
import com.wang.ws.service.WeatherModel;

/**
 * webservice客户端
 * 
 * @author wang
 *
 */
public class WeatherClient {

	public static void main(String[] args) throws MalformedURLException {
		URL wsdlDocumentLocation = new URL("http://localhost:12345/weather?wsdl");
		QName serviceName = new QName("http://service.ws.wang.com/", "WeatherInterfaceImplService");
		Service service = Service.create(wsdlDocumentLocation, serviceName);
		WeatherInterfaceImpl weatherInterfaceImpl = service.getPort(WeatherInterfaceImpl.class);
		List<WeatherModel> list = weatherInterfaceImpl.queryWeather("北京");
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
