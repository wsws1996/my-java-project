import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Process {

	public static void main(String[] args) throws IOException {
		File file = new File("/home/wang/桌面/zsd");
		Scanner scanner = new Scanner(file);
		FileWriter fileWriter = new FileWriter("/home/wang/桌面/zsd.txtbyjava");
		int count = 0;
		while (scanner.hasNextLine()) {
			String nextLine = scanner.nextLine();
			if (nextLine.length() > 0) {
//				nextLine = nextLine.replace(" ", "");
				// List<Character> asList = Arrays.asList('，', '。', '；');
//				List<Character> asList = Arrays.asList('。','.', '：',':',';','；');
//				while (!asList.contains(nextLine.charAt(nextLine.length() - 1))
//						/*&& !Character.isDigit(nextLine.charAt(0))*/) {
//					String tmpLine = scanner.nextLine();
//					tmpLine = tmpLine.replace(" ", "");
//					nextLine = nextLine + tmpLine;
//					// nextLine = nextLine + ";";
//				}
				// StringBuilder stringBuilder = new StringBuilder(replace);
				// if (stringBuilder.indexOf("第") != -1 &&
				// stringBuilder.indexOf("页") != -1
				// && stringBuilder.indexOf("共") != -1) {
				// stringBuilder.delete(0, 6);
				// System.out.println(stringBuilder.toString());
				// }
				// count += replace.length();
				fileWriter.write(nextLine + "\n");
			}
		}
		System.out.println(count);
		scanner.close();
		fileWriter.close();
	}

}
