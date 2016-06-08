package com.wang.ws.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {

	public static void main(String[] args) throws IOException {
		URL url=new URL("http://localhost:12345/weather");
		HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("POST");
		
		httpURLConnection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
		
		httpURLConnection.setDoInput(true);
		httpURLConnection.setDoOutput(true);
		httpURLConnection.getOutputStream().write(requestString("上海").getBytes());
		InputStream inputStream= httpURLConnection.getInputStream();
		ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
		int len=-1;
		byte [] b=new byte [1024];
		while ((len=inputStream.read(b, 0, 1024))!=-1) {
			byteArrayOutputStream.write(b, 0, len);
		}
		String responseString =byteArrayOutputStream.toString();
		System.out.println(responseString);
		
		inputStream.close();
		byteArrayOutputStream.close();
	}
	
	public static String requestString(String cityName) {
		String xmlString="<?xml version=\"1.0\" ?>"
				+ "<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">"
				+ "<S:Body>"
				+ "<ns2:queryWeather xmlns:ns2=\"http://server.weather.jaxws.ws.wang.com/\">"
				+ "<arg0>"+cityName+"</arg0>"
				+ "</ns2:queryWeather>"
				+ "</S:Body>"
				+ "</S:Envelope>";
		return xmlString;
	}
}
