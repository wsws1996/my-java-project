import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class Client {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		Socket s=new Socket("192.168.1.103",10007);
		System.out.println("连接建立成功");
		FileInputStream fis=new FileInputStream(new File("e:\\王雨彤.bmp"));
		
		OutputStream out=s.getOutputStream();
		byte [] buf=new byte[1024];
		int len=0;
		while ((len=fis.read(buf))!=-1) {
			System.out.println("正在发送");
			out.write(buf,0,len);
		}
		s.shutdownOutput();
		InputStream in=s.getInputStream();
		byte[]bufIn=new byte[1024];
		int num=in.read(bufIn);
		System.out.println(new String(bufIn,0,num));
		fis.close();
		s.close();
	}

}
