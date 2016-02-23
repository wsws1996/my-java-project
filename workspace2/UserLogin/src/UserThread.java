import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class UserThread implements Runnable {
	private Socket s;
	public UserThread(Socket s) {
		// TODO Auto-generated constructor stub
		this.s=s;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println(s.getInetAddress().getHostAddress()+"connected...");
			for(int x=0;x<3;++x){
				BufferedReader bufin=
					new BufferedReader(new InputStreamReader(s.getInputStream()));
				System.out.println(1);
					String name=bufin.readLine();
					if(name==null)
						break;
				PrintWriter out=new PrintWriter(s.getOutputStream(), true);
				System.out.println(2);
				BufferedReader bufr=
					new BufferedReader(new FileReader(new File("e:\\User.txt")));
				String line=null;
				boolean flag=false;
				System.out.println(3);
				while (null!=(line=bufr.readLine())) {
					if(line.equals(name)){
						flag=true;
						break;
					}
				}
				System.out.println(4);
				if(flag==true){
					System.out.println("�û�"+name+"��ip:"+s.getInetAddress().getHostAddress()+"��¼�ɹ�");
					out.println("��ӭ����");
					s.close();
					break;
				}
				else {
					System.out.println("�û�"+name+"��ip:"+s.getInetAddress().getHostAddress()+"��¼ʧ��");
					out.println("�û���"+name+"�����ڣ�"+"������¼�롣");
				}
				System.out.println(5);
				bufr.close();
			}
			s.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}