package newhash;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	private static FileWriter fileWriter;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入需要修改MD5的文件路径");
		String path=scanner.nextLine();
		scanner.close();
		File f = new File(path);
		process(f);
		System.out.println("全部完成");

	}

	public static void process(File file) throws IOException {
		File flist[] = file.listFiles();
		if (flist == null || flist.length == 0) {
			return;
		}

		for (File f : flist) {
			if (f.isDirectory()) {
				System.out.println("正在处理" + f.getAbsolutePath() + "文件夹下的文件");
				process(f);
			} else {
				// 这里将列出所有的文件
				System.out.println("正在处理" + f.getAbsolutePath());
				fileWriter = new FileWriter(f.getAbsolutePath(),true);
				System.out.println("写入中……");
				fileWriter.write(0);
				fileWriter.flush();
				System.out.println("完成");
			}
		}
	}
}