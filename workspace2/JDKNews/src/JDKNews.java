import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;


public class JDKNews {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Direction2 d=Direction2.RIGHT;
//		System.out.println(d);
////		System.out.println(d.getName());
////		d.show();
//		Direction3 d=Direction3.FRONT;
//		System.out.println(d);
//		System.out.println(d.getName());
//		d.show();
//		Direction3 dd=Direction3.BEHIND;
//		switch (dd) {
//		case FRONT:
//			System.out.println("ǰ");
//			break;
//		case BEHIND:
//			System.out.println("��");
//			break;
//		default:
//			break;
//		}
//		int x=0x10_000;
//		System.out.println(x);
//		String s="��ˬ";
//		switch (s) {
//		case "��ˬ":
//			System.out.println("��ˬ");
//			break;
//
//		default:
//			break;
//		}
//		ArrayList<String>array=new ArrayList<>();
//		Method();
		//inter.dew();
		inter i=new interf();
		i.show();
	}

//	private static void Method() {
//		// TODO Auto-generated method stub
//		try(	FileReader fr=new FileReader("f.txt");
//				FileWriter fw=new FileWriter("a.txt");){
//		int ch=0;
//		while (fr.read()!=-1) {
//			fw.write(ch);
//		}
//			
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
	
}
interface inter{
	
	public abstract void show();
	public default void defa() {
		System.out.println("jdk8");
	}
	public static void dew() {
		System.out.println("static jdk8");
	}
}
class interf implements inter{
	public void show() {
		System.out.println("��д�ӿڵķ���");
	}
}