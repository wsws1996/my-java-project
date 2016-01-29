import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.TextArea;


public class MyIE extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1965800688454966912L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyIE frame = new MyIE();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyIE() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 5, 353, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u8F6C\u5230");
		btnNewButton.setBounds(356, 5, 78, 21);
		contentPane.add(btnNewButton);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(0, 32, 434, 229);
		contentPane.add(textArea);
btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String url=textField.getText();
				int index1=url.indexOf("//")+2;
				
				int index2=url.indexOf("/",index1);
				
				String str=url.substring(index1, index2);
				
				String path=url.substring(index2);
				String arr[]=str.split(":");
				try {
					Socket s=new Socket(arr[0],Integer.parseInt(arr[1]));
					PrintWriter out=new PrintWriter(s.getOutputStream(),true);
					out.println("GET "+path+" HTTP/1.1");
					out.println("Accept: */*");
					out.println("Accept-Language: zh-CN");
					out.println("Host:"+str);
					out.println("Connection: keep-alive");
					
					out.println();
					out.println();
					
					InputStream in=s.getInputStream();
					byte[]bufr=new byte[1024];
					in.read(bufr);
					textArea.setText(new String(bufr));
					s.close();
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
