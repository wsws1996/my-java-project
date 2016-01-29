import java.net.InetAddress;
import java.net.UnknownHostException;


public class IPDemo {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		InetAddress[] ia=InetAddress.getAllByName("www.baidu.com");
		for (InetAddress inetAddress : ia) {
			System.out.println(inetAddress.getHostAddress());
		}
		InetAddress[] sh=InetAddress.getAllByName("hao360.cn");
		for (InetAddress inetAddress : sh) {
			System.out.println(inetAddress.getHostAddress());
		}
	}

}
