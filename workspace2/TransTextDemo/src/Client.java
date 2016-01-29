import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;


public class Client {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//创建客户端的socket服务 
			Socket s=new Socket("192.168.253.12",10003);
			Scanner sc=new Scanner(System.in);
			OutputStream out=s.getOutputStream();
			InputStream in= s.getInputStream();
			System.out.println("连接成功");
			while(true){
				String line =sc.next();
				if (line.equals("over")) {
					break;
				}
				out.write(line.getBytes());
				byte [] buf=new byte[1024];
				in.read(buf);
				System.out.println(new String(buf));
			}
			sc.close();
			s.close();
	}

}
