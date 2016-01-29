import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Sever {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		ServerSocket ss=new ServerSocket(10003);
		Socket s=ss.accept();
		InputStream in= s.getInputStream();
		OutputStream out=s.getOutputStream();
		while (true) {
			byte [] buf=new byte[1024];
			in.read(buf);
			String line=new String(buf);
			String up=line.toUpperCase();
			System.out.println(s.getInetAddress().getHostAddress()+"connected...");
			System.out.println(line);
			out.write(up.getBytes());
		}
	}

}
