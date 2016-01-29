import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class Regex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//replaceAll("我我...要要要要....学学学学...编...编程","\\.", "");
		//getDemo();
		//ipsort();
		checkmail();
	}
	public static void checkmail() {
		String reg="[a-zA-Z0-9_]{6,12}@[a-zA-Z0-9]+(\\.[a-zA-Z]+){1,3}";
		String mail="1786578565@163.com.cn.org.hj";
		reg="\\w+@\\w+(\\.\\w+)+";
		System.out.println(mail.matches(reg));
	}
	public static void ipsort() {
		String ip
		="192.168.1.254 102.49.23.13 10.10.10.10 2.2.2.2 8.109.90.30";
		ip=ip.replaceAll("(\\d+)", "00$1");
		ip=ip.replaceAll("0*(\\d{3})", "$1");
		System.out.println(ip);
		String [] arr=ip.split(" +");
		TreeSet<String>ts=new TreeSet<String>();
		for(String s:arr){
			ts.add(s);
		}
		for (String string : ts) {
			System.out.println(string.replaceAll("0*(\\d+)", "$1"));
		}
	}
	public static void getDemo() {
		String str="ming tian jiu yao fang jia le";
		String reg="\\b[a-z]{3}\\b";
		Pattern p=Pattern.compile(reg);
		Matcher m=p.matcher(str);
		while (m.find()) {
			System.out.println(m.group());
		}
		
	}
	public static void replaceAll(String str,String reg,String newStr) {
		str=str.replaceAll(reg, newStr);
		str=str.replaceAll("(.)\\1+","$1");
		System.out.println(str);
	}
	public static void splitdemo() {
		String str="czzzzzswwwwwqyy";
		String reg="(.)\\1+";
		String [] arr=str.split(reg);
		System.out.println(arr.length);
		for(String s:arr){
			System.out.println(s);
		}
	}
	public static void demo() {
		String str="a665476";
		String reg="[abcd]\\d?";
		System.out.println(str.matches(reg));
	}
	public static void checkQQ() {
		String qq="14781363182";
		String regex="[1][358]\\d{9}";
		if (qq.matches(regex)) {
			System.out.println("QQ:"+qq+"是正确的");
		}else {
			System.out.println("QQ:"+qq+"是错误的");
		}
	}
	public static void check() {
		String qq="124发576989";
		int len=qq.length();
		if (!(len>=5&&len<=15)) {
			System.out.println("长度过短或过长");
			return;
		}
		if(!qq.startsWith("0")){
			try {
				Long.parseLong(qq);
				System.out.println("正确");
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("出现非法字符。。。");
			}
		/*	char [] arr=qq.toCharArray();
			boolean flag=true;
			for (int x = 0; x < arr.length; x++) {
				if(arr[x]<'0'||arr[x]>'9'){
					flag=false;
					break;
				}
			}
			if (flag) {
				System.out.println("qq:"+qq+"是正确的");
			} else {
				System.out.println("出现非法字符");
			}*/
		}else{
			System.out.println("不可以0开头");
		}
	}
}
