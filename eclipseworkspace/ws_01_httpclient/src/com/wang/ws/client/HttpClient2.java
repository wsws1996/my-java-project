package com.wang.ws.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient2 {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://localhost:12345/rest/student/querylist/001?_type=json");
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");

		httpURLConnection.setDoInput(true);
		httpURLConnection.setDoOutput(true);

		InputStream inputStream = httpURLConnection.getInputStream();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		int len = -1;
		byte[] b = new byte[1024];
		while ((len = inputStream.read(b, 0, 1024)) != -1) {
			byteArrayOutputStream.write(b, 0, len);
		}
		String responseString = byteArrayOutputStream.toString();
		System.out.println(responseString);

		inputStream.close();
		byteArrayOutputStream.close();
	}
}
