import java.net.ServerSocket;
import java.net.Socket;


public class Sever {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		ServerSocket ss=new ServerSocket(10008);
		
		while (true) {
			Socket s=ss.accept();
			new Thread(new UserThread(s)).start();
		}
	}

}
