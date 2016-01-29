import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Sever {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ServerSocket ss=new ServerSocket(10006);
		Socket s=ss.accept();
		System.out.println(s.getInetAddress().getHostAddress()+"connected...");
		
		BufferedReader bufIn=new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		PrintWriter out=new PrintWriter(new FileWriter("Sever.txt"),true);
		
		String line=null;
		while ((line=bufIn.readLine())!=null) {
			out.println(line);
			System.out.println(line);
		}
		System.out.println("文件读取完毕");
		PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
		pw.println("上传成功");
		
		out.close();
		s.close();
		ss.close();
	}

}
