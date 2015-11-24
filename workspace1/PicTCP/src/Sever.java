import java.net.ServerSocket;
import java.net.Socket;

public class Sever {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		ServerSocket ss = new ServerSocket(10007);
		while (true) {
			Socket s = ss.accept();
			Thread th=new Thread(new ReceivePic(s));
			th.start();
			/*Socket s = ss.accept();
			InputStream in = s.getInputStream();

			FileOutputStream fos = new FileOutputStream("sever.bmp");
			byte[] buf = new byte[1024];
			int len = 0;
			while (-1 != (len = in.read(buf))) {
				fos.write(buf, 0, len);
			}
			OutputStream outputStream = s.getOutputStream();
			outputStream.write("上传成功".getBytes());
			fos.close();
			s.close();
			ss.close();*/
		}
	}
}
