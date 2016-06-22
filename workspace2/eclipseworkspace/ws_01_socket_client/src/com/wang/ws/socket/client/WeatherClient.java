package com.wang.ws.socket.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class WeatherClient {
	public static void main(String[] args) throws IOException {

		while (true) {
			Socket socket = null;
			DataInputStream dataInputStream = null;
			DataOutputStream dataOutputStream = null;
			try {
				socket = new Socket("127.0.0.1", 12345);

				dataInputStream = null;
				dataOutputStream = null;

				dataOutputStream = new DataOutputStream(socket.getOutputStream());
				String cityName = "北京";
				dataOutputStream.writeUTF(cityName);
				System.out.println("to server ..." + cityName);

				dataInputStream = new DataInputStream(socket.getInputStream());
				String result = dataInputStream.readUTF();
				System.out.println("from server ..." + result);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				dataInputStream.close();
				dataOutputStream.close();

				socket.close();
			}
		}
	}
}
