package com.wang.ws.socket.server.thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class WeatherRunnable implements Runnable {

	private Socket socket;

	public WeatherRunnable(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		DataInputStream dataInputStream = null;
		DataOutputStream dataOutputStream = null;

		try {

			dataInputStream = new DataInputStream(socket.getInputStream());
			String cityName = dataInputStream.readUTF();
			System.out.println("from client ..." + cityName);

			dataOutputStream = new DataOutputStream(socket.getOutputStream());

			Thread.sleep(1000);
			String result = "晴朗";
			dataOutputStream.writeUTF(result);
			System.out.println("to client ..." + result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dataInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				dataOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
