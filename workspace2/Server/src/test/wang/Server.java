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
	//	pw.println("�ɹ�");
		pw.println("<html><font size=7 color=green> ע��ɹ�</font></html>");
		s.close();
		ss.close();
		System.out.println("test");
	}

}
