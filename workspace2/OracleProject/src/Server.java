import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(10016);
		byte[] receiveBuf = new byte[1024];

		while (true) {
			Socket s = ss.accept();
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();
			while (in.read(receiveBuf) != -1) {
				System.out.println(new String(receiveBuf));
			}
			s.close();
		}
	}
}
