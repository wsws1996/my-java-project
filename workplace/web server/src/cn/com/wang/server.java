package cn.com.wang;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket ss=new ServerSocket(10009);
		Socket s=ss.accept();
		InputStream in=s.getInputStream();
		byte [] buf =new byte[1024];
		int len =in.read(buf);
		System.out.println(new String(buf,0,len));
		OutputStream out=s.getOutputStream();
		PrintWriter pw=new PrintWriter(out,true);
		pw.println("succeed");
		s.close();
		ss.close();
	}
}
