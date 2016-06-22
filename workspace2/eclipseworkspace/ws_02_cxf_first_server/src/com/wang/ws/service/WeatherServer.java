package com.wang.ws.service;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class WeatherServer {

	public static void main(String[] args) {
		JaxWsServerFactoryBean jaxWsServerFactoryBean = new JaxWsServerFactoryBean();
		jaxWsServerFactoryBean.setAddress("http://127.0.0.1:12345/weather");
		jaxWsServerFactoryBean.setServiceClass(WeatherInterface.class);
		jaxWsServerFactoryBean.setServiceBean(new WeatherInterfaceImpl());

		jaxWsServerFactoryBean.create();
	}

}
