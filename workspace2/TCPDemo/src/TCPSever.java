import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPSever {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		ServerSocket ss=new ServerSocket(10003);
		while (true) {
			Socket s=ss.accept();
			InputStream in= s.getInputStream();
			byte [] buf=new byte[1024];
			in.read(buf);
			System.out.println(new String(buf));
			OutputStream out=s.getOutputStream();
			System.out.println(s.getInetAddress().getHostAddress()+"connected...");
			out.write(("收到,服务器地址为："+InetAddress.getLocalHost().getHostAddress()).getBytes());
			s.close();
		}
	}

}
