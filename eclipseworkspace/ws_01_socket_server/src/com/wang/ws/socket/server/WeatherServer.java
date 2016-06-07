package com.wang.ws.socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.wang.ws.socket.server.thread.WeatherRunnable;

public class WeatherServer {
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(12345);
		System.out.println("启动天气查询服务......");
		while (true) {
			Socket socket = null;
			try {
				socket = serverSocket.accept();
				new Thread(new WeatherRunnable(socket)).start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
