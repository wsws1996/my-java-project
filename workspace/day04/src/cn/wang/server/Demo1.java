package cn.wang.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = new ServerSocket(10009);
		Socket socket = serverSocket.accept();
		OutputStream outputStream = socket.getOutputStream();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/public/1.html")));
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			outputStream.write(line.getBytes());
		}
		outputStream.close();
		bufferedReader.close();
		socket.close();
		serverSocket.close();
	}

}
