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
		System.out.println("��������Ҫ�޸�MD5���ļ�·��");
		String path=scanner.nextLine();
		scanner.close();
		File f = new File(path);
		process(f);
		System.out.println("ȫ�����");

	}

	public static void process(File file) throws IOException {
		File flist[] = file.listFiles();
		if (flist == null || flist.length == 0) {
			return;
		}

		for (File f : flist) {
			if (f.isDirectory()) {
				System.out.println("���ڴ���" + f.getAbsolutePath() + "�ļ����µ��ļ�");
				process(f);
			} else {
				// ���ｫ�г����е��ļ�
				System.out.println("���ڴ���" + f.getAbsolutePath());
				fileWriter = new FileWriter(f.getAbsolutePath(),true);
				System.out.println("д���С���");
				fileWriter.write(0);
				fileWriter.flush();
				System.out.println("���");
			}
		}
	}
}