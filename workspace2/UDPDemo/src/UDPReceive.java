import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class UDPReceive {

	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		Frame f=new Frame();
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		TextArea t=new TextArea();
		f.add(t);
		f.setVisible(true);
		@SuppressWarnings("resource")
		DatagramSocket ds=new DatagramSocket(10000);
		while(true){
			byte []data=new byte[1024];
			DatagramPacket dp=new DatagramPacket(data, data.length);
			//接受数据
			System.out.print("开始接受");
			ds.receive(dp);
			System.out.println("接受完毕");
			String ip=dp.getAddress().getHostAddress();
			String s=new String(dp.getData(),0,dp.getLength());
			int port=dp.getPort();
			t.append(ip+"::"+s+"::"+port+"\t\n");
		}
	}

}
