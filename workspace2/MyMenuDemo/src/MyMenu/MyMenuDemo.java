package MyMenu;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class MyMenuDemo {
	private Frame f;
	private MenuBar bar;
	private Menu fileMenu;
	private MenuItem closeItem,saveItem,openItem;
	private TextArea ta;
	private File file;
	public MyMenuDemo() {
		// TODO Auto-generated constructor stub
		init();
	}
	public void init() {
		f=new Frame("带有菜单项的窗体");
		f.setBounds(300, 100, 650, 600);
		
		bar=new MenuBar();
		fileMenu=new Menu("文件");
		openItem=new MenuItem("打开");
		saveItem=new MenuItem("保存");
		closeItem=new MenuItem("退出");
		ta=new TextArea();
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(closeItem);
		bar.add(fileMenu);
		f.add(ta);
		f.setMenuBar(bar);
		myEvent();
		f.setVisible(true);
	}
	public void myEvent() {
		openItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FileDialog openDia=new FileDialog(f,"您将打开",FileDialog.LOAD);
				openDia.setVisible(true);
				String dir=openDia.getDirectory();
				String name=openDia.getFile();
				String absName=dir+name;
				try {
					file=new File(absName);
					BufferedReader bufr=new BufferedReader(new FileReader(file));
					String line=null;
					ta.setText(line);
					while ((line=bufr.readLine())!=null) {
						ta.append(line+"\r\n");
					}	
					bufr.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					throw new RuntimeException("读取失败");
				}
			}
		});
		ta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode()==KeyEvent.VK_S&&e.isControlDown()){
					savefile();
				}
			}
		});
		saveItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				savefile();
			}
		});
		closeItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	private void savefile(){
		if(file==null){
			FileDialog saveDia=new FileDialog(f,"您将保存",FileDialog.SAVE);
			saveDia.setVisible(true);
			String dirPath=saveDia.getDirectory();
			String fileName=saveDia.getFile();
			if(dirPath==null||fileName==null)
				return;
			
			file= new File(dirPath,fileName);
		}	
		try {
			BufferedWriter bufw=new BufferedWriter(new FileWriter(file));
			
			String text=ta.getText();
			bufw.write(text);
			bufw.flush();
			bufw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyMenuDemo();
	}

}
