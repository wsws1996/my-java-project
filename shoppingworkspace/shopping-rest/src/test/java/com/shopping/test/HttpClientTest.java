package com.shopping.test;

import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class HttpClientTest {

	@Test
	public void doGet() throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet get = new HttpGet("http://www.baidu.com");
		CloseableHttpResponse response = httpClient.execute(get);
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity, "utf-8");
		System.out.println(string);
		response.close();
		httpClient.close();

	}

	@Test
	public void doGetWithParam() throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		URIBuilder uriBuilder = new URIBuilder("http://www.sogou.com/web");
		uriBuilder.addParameter("query", "范冰冰");
		HttpGet get = new HttpGet(uriBuilder.build());

		CloseableHttpResponse response = httpClient.execute(get);
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity, "utf-8");
		System.out.println(string);
		response.close();
		httpClient.close();

	}

	@Test
	public void doPost() throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost("http://rest.shopping.com/httpclient/post.html");
		CloseableHttpResponse response = httpClient.execute(post);
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity, "utf-8");
		System.out.println(string);
		response.close();
		httpClient.close();

	}

	@Test
	public void doPostWithParam() throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost("http://rest.shopping.com/httpclient/post.html");
		ArrayList<NameValuePair> kvList = new ArrayList<>();
		kvList.add(new BasicNameValuePair("username", "zhangsan"));
		kvList.add(new BasicNameValuePair("password", "123"));

		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(kvList, "utf-8");
		post.setEntity(entity);

		CloseableHttpResponse response = httpClient.execute(post);
		String string = EntityUtils.toString(response.getEntity());
		System.out.println(string);
		response.close();
		httpClient.close();

	}
}
