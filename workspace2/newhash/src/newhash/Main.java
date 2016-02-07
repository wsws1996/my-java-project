package newhash;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class Main {

	private static FileWriter fileWriter;

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("警告！使用该程序处理后文件可能受损！！！");
		System.out.println("该程序基于fedora23开发，按照跨平台标准开发，但未做跨平台测试，是否继续？（Y/N）");
		String choice = scanner.nextLine();
		if (!choice.equalsIgnoreCase("Y")) {
			scanner.close();
			return;
		}
		System.out.println("输入路径");
		String path = scanner.nextLine();
		File f = new File(path);
		processMD5(f);
		System.out.println("MD5处理完成，您是否要处理文件名？（Y/N）");
		choice = scanner.nextLine();
		if (choice.equalsIgnoreCase("Y")) {
			processName(f);
		}
		System.out.println("全部完成");
		scanner.close();
	}

	public static void processMD5(File file) throws IOException {
		File flist[] = file.listFiles();
		if (flist == null || flist.length == 0) {
			return;
		}

		for (File f : flist) {
			if (f.isDirectory()) {
				System.out.println("正在处理" + f.getAbsolutePath() + "下的文件");
				processMD5(f);
			} else {
				System.out.println("正在处理" + f.getAbsolutePath() + "的MD5");
				fileWriter = new FileWriter(f, true);
				System.out.println("处理中");
				fileWriter.write(0);
				fileWriter.flush();
				System.out.println("完成");
			}
		}
	}

	public static void processName(File file) throws IOException {
		File flist[] = file.listFiles();
		if (flist == null || flist.length == 0) {
			return;
		}
		for (File f : flist) {
			if (f.isDirectory()) {
				System.out.println("正在处理" + f.getAbsolutePath() + "下的文件");
				String fullname = f.getAbsolutePath();
				String name = fullname.substring(fullname.lastIndexOf(

				System.getProperty("file.separator")) + 1);
				String newpath = fullname.substring(0, fullname.lastIndexOf(

				System.getProperty("file.separator"))) +

				System.getProperty("file.separator")
						+ StringUtils.join(name.toCharArray(), '山');
				File newDir = new File(newpath);
				f.renameTo(newDir);
				processName(newDir);
			} else {
				System.out.println("正在处理" + f.getAbsolutePath() + "的名称");
				String fullname = f.getAbsolutePath();
				String name = fullname.substring(fullname.lastIndexOf(System
						.getProperty("file.separator")) + 1, fullname
						.lastIndexOf("."));
				if (name.equals("批量将rmvb转为mp4")) {
					continue;
				}
				String newpath = fullname.substring(0, fullname
						.lastIndexOf(System.getProperty("file.separator")))
						+ System.getProperty("file.separator")
						+ StringUtils.join(name.toCharArray(), '山')
						+ fullname.substring(fullname.lastIndexOf("."),
								fullname.length());
				f.renameTo(new File(newpath));
			}
		}
	}
}