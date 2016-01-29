package test.wang;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ServerSocket ss=new ServerSocket(10009);
		Socket s=ss.accept();
		
		OutputStream out=s.getOutputStream();
		PrintWriter pw=new PrintWriter(out,true);
	//	pw.println("成功");
		pw.println("<html><font size=7 color=green> 注册成功</font></html>");
		s.close();
		ss.close();
		System.out.println("test");
	}

}
