package newhash;

import java.io.File;

import org.apache.commons.lang3.StringUtils;

public class Test {

	public static void main(String[] args) {
		File file = new File("/home/wang/桌面/123456.txt");
		String fullname = file.getAbsolutePath();
		String name = fullname.substring(fullname.lastIndexOf("/") + 1,
				fullname.lastIndexOf("."));
		String newpath = fullname.substring(0, fullname.lastIndexOf("/")) + "/"
				+ StringUtils.join(name.toCharArray(), '中')+fullname.substring(fullname.lastIndexOf("."), fullname.length());
		file.renameTo(new File(newpath));
	}

}
