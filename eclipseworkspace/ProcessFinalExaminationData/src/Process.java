import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Process {

	public static void main(String[] args) throws IOException {
		File file = new File("/home/wang/桌面/计算机网络(谢希仁版)复习资料整理(期末考试必备).txt");
		Scanner scanner = new Scanner(file);
		FileWriter fileWriter = new FileWriter("/home/wang/桌面/计算机网络(谢希仁版)复习资料整理(期末考试必备).txtbyjava");
		while (scanner.hasNextLine()) {
			String nextLine = scanner.nextLine();
			if (nextLine.length() > 0) {
				String replace = nextLine.replace(" ", "");
				StringBuilder stringBuilder = new StringBuilder(replace);
//				if (stringBuilder.indexOf("第") != -1 && stringBuilder.indexOf("页") != -1
//						&& stringBuilder.indexOf("共") != -1) {
//					stringBuilder.delete(0, 6);
//					System.out.println(stringBuilder.toString());
//				}
				fileWriter.write(stringBuilder + "\n");
			}
		}
		scanner.close();
		fileWriter.close();
	}

}
