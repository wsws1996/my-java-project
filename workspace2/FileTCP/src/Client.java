import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Socket s=new Socket("192.168.253.12",10006);
		BufferedReader bufr=
				new BufferedReader(new FileReader("C:\\Users\\wangshuang\\desktop\\1.txt"));
		PrintWriter out=new PrintWriter(s.getOutputStream(),true);
		
		String line=null;
		while ((line=bufr.readLine())!=null) {
			out.println(line);
		}
		s.shutdownOutput();
		BufferedReader bufIn=new BufferedReader(new InputStreamReader(s.getInputStream()));
		String str=bufIn.readLine();
		System.out.println(str);
		bufr.close();
		s.close();
	}

}
