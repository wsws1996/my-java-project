import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class ReceivePic implements Runnable {
	private Socket s;
	public ReceivePic(Socket s) {
		// TODO Auto-generated constructor stub
		this.s=s;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			int i=0;
			String ip= s.getInetAddress().getHostAddress();
			System.out.println(ip+"...connected");
			InputStream in = s.getInputStream();
			File file=new File(ip+".jpg");
			while (file.exists()) {
				String num=new Integer(i).toString();
				file=new File(ip+"("+num+")"+".jpg");
				i++;
			}
			FileOutputStream fos = new FileOutputStream(file);
			byte[] buf = new byte[1024];
			int len = 0;
			while (-1 != (len = in.read(buf))) {
				fos.write(buf, 0, len);
			}
			OutputStream outputStream = s.getOutputStream();
			outputStream.write("上传成功".getBytes());
			fos.close();
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
