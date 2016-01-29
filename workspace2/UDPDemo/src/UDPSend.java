import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;


public class UDPSend {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		try {
			@SuppressWarnings("resource")
			DatagramSocket ds=new DatagramSocket();
			while(true){
				@SuppressWarnings("resource")
				Scanner sc=new Scanner(System.in);
				String s=sc.nextLine();
				if(s.equals("886"))
					break;
				//确定数据并封包
				byte [] data=s.getBytes();
				DatagramPacket dp=new DatagramPacket(data, data.length,InetAddress.getByName("192.168.253.255"), 10000);
				//发包
				ds.send(dp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
