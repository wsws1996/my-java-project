import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;


public class Test {
	private Frame f;
	private TextField tf;
	private Button but;
	private TextArea ta;
	
	private Dialog d;
	private Label lab;
	private Button okBun;
	
	public Test() {
		// TODO Auto-generated constructor stub
		init();
	}
	public void init() {
		f=new Frame("文件目录浏览器");
		f.setBounds(300, 100, 600, 500);
		f.setLayout(new FlowLayout());
		
		tf=new TextField(60);
		
		but=new Button("转到");
		
		
		d=new Dialog(f,"提示信息~~~",true);
		d.setLayout(new FlowLayout());
		d.setBounds(400,200,240,150);
		
		lab=new Label();
		lab.setVisible(true);
		okBun=new Button("确定");
		d.add(lab);
		d.add(okBun);
		
		ta=new TextArea(25,70);
		
		f.add(tf);
		f.add(but);
		f.add(ta);
		
		myEvent();
		f.setVisible(true);
	}
	private void myEvent() {
		tf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e){
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					showDir();
				}
			}
		});
		okBun.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e){
				if (e.getKeyCode()==KeyEvent.VK_ENTER)
					d.setVisible(false);
			}
		});
		d.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				d.setVisible(false);
			}
		});
		okBun.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				d.setVisible(false);
			}
		});
		but.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showDir();
			}
		});
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	private void showDir() {
		String dirPath= tf.getText();
		
		File dir=new File(dirPath);
		
		if(dir.exists()&&dir.isDirectory()){
			ta.setText("");
			String []names=dir.list();
			for (String name : names) {
				ta.append(name+"\r\n");
			}
		}
		else {
			String info="您输入的信息："+dirPath+"是错误的";
			lab.setText(info);
			d.setVisible(true);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test();
	}

}
