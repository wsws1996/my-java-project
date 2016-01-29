import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;


public class MyIE {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		Socket s=new Socket("192.168.1.103",8080);
		PrintWriter out=new PrintWriter(s.getOutputStream(),true);
		out.println("GET /myweb/Index.html HTTP/1.1");
		out.println("Accept: */*");
		out.println("Accept-Language: zh-CN");
		out.println("Host: 192.168.1.103:11000");
		out.println("Connection: keep-alive");
		
		out.println();
		out.println();
		
		InputStream in=s.getInputStream();
		byte[]bufr=new byte[1024];
		in.read(bufr);
		System.out.println(new String(bufr));
		s.close();
	}

}
