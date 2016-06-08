package com.wang.ws.area.server;

import javax.xml.ws.Endpoint;

import com.wang.ws.area.server.service.AreaServiceInterfaceImpl;

public class AreaServer {

	public static void main(String[] args) {
		Endpoint.publish("http://127.0.0.1:12345/area", new AreaServiceInterfaceImpl());
	}

}
