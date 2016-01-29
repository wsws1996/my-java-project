import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		Socket s=new Socket("172.21.35.1",10008);
		BufferedReader bufr=
				new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(s.getOutputStream(),true);
		BufferedReader bufin=
				new BufferedReader(new InputStreamReader(s.getInputStream()));
		for(int x=0;x<=2;++x){
			String line=bufr.readLine();
			if(line==null)
				break;
			out.println(line);
			String info=bufin.readLine();
			System.out.println(info);
			if(info.contains("»¶Ó­"))
				break;
		}
		bufr.close();
		s.close();
	
	}

}
