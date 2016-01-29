import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class SeverDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ServerSocket ss=new ServerSocket(11000);
		
		Socket s=ss.accept();
		System.out.println(s.getInetAddress().getHostAddress());
		PrintWriter out=new PrintWriter(s.getOutputStream(), true);
		InputStream in=s.getInputStream();
		out.println("<font color='red' size='7'> ¿Í»§¶ËÄãºÃ  </font>");
		byte[] buf=new byte[1024];
		in.read(buf);
		System.out.println(new String(buf));
		s.close();
		ss.close();
	}

}
