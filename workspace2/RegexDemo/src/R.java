import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class R {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		get();
		//getmail();
	}
	public static void get() throws Exception {
		URL url=new URL("http://127.0.0.1:8080/myweb/Demo.html");
		InputStream in=url.openStream();
		BufferedReader bufr=new BufferedReader(new InputStreamReader(in));
		String line=null;
		Pattern p=Pattern.compile("[0-9a-zA-Z]+@[0-9a-zA-Z]+.com");
		while ((line=bufr.readLine())!=null) {
			Matcher m=p.matcher(line);
			while (m.find()) {
				System.out.println(m.group());
			}
		}
	}
	public static void getmail() throws Exception {
		BufferedReader bufr=new BufferedReader(new FileReader(new File("e:\\mail.txt")));
		String line=null;
		Pattern p=Pattern.compile("[0-9a-zA-Z]+@[0-9a-zA-Z]+.com");
		while ((line=bufr.readLine())!=null) {
			Matcher m=p.matcher(line);
			while (m.find()) {
				System.out.println(m.group());
			}
			
		}
		bufr.close();
	}
}
