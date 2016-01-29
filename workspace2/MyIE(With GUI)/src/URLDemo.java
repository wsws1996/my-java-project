import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


public class URLDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		URL url=new URL("http://127.0.0.1:8080/myweb/Index.html");
		URLConnection conn=url.openConnection();
		InputStream in=conn.getInputStream();
		byte []bufr=new byte[1024];
		in.read(bufr);
		System.out.println(new String(bufr));
	}

}
