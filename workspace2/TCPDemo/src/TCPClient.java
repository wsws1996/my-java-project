import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class TCPClient {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//创建客户端的socket服务
		System.out.println("begin");
		@SuppressWarnings("resource")
		Socket s=new Socket("172.23.229.3",10003);
		OutputStream out=s.getOutputStream();
		out.write("TCP connection successing".getBytes());
		InputStream in= s.getInputStream();
		byte [] buf=new byte[1024];
		in.read(buf);
		System.out.println(new String(buf));
	}
}
 