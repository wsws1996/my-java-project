package com.wang.ws.area.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.wang.ws.area.server.service.AreaServiceInterfaceImpl;

public class AreaClient {

	public static void main(String[] args) throws MalformedURLException {
		URL wsdlDocumentLocation = new URL("http://localhost:12345/area?wsdl");
		QName serviceName = new QName("http://service.server.area.ws.wang.com/", "AreaServiceInterfaceImplService");
		Service service = Service.create(wsdlDocumentLocation, serviceName);
		AreaServiceInterfaceImpl areaServiceInterfaceImpl = service.getPort(AreaServiceInterfaceImpl.class);

		String requestString = getXmlString("1.", 15, 20);

		String resultString = areaServiceInterfaceImpl.queryArea(requestString);
		System.out.println(resultString);

	}

	public static String getXmlString(String parentId, int start, int end) {
		String xmlString = "<?xml version=\"1.1\"  encoding=\"utf-8\"?>" + "<queryarea>" + "<parentid>" + parentId
				+ "</parentid>" + "<start>" + start + "</start>" + "<end>" + end + "</end>" + "</queryarea>";

		return xmlString;
	}
}
