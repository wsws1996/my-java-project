package cn.wang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Demo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		URL url = new URL("http://localhost:8080/day08/servlet/ServletDemo1");
		HttpURLConnection httpURLConnection = (HttpURLConnection) url
				.openConnection();
		httpURLConnection.setDoOutput(true);
		httpURLConnection.setRequestProperty("xxx", "yyy");
		OutputStream outputStream= httpURLConnection.getOutputStream();
		outputStream.write("name=wangshuang".getBytes());
		httpURLConnection.getResponseCode();
	}

	public static void test() throws MalformedURLException, IOException {
		URL url = new URL("http://localhost:8080/day08/servlet/ServletDemo1");
		HttpURLConnection httpURLConnection = (HttpURLConnection) url
				.openConnection();
		BufferedReader br=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		System.out.println(httpURLConnection.getResponseCode());
		System.out.println(httpURLConnection.getHeaderField("server"));
		String str=null;
		while ((str=br.readLine())!=null) {
			System.out.println(str);
		}
	}

}
