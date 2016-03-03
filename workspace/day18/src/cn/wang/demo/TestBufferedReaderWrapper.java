package cn.wang.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestBufferedReaderWrapper {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(
				"src/cn/wang/demo/TestBufferedReaderWrapper.java"));
		BufferedReaderWrapper wrapper = new BufferedReaderWrapper(
				bufferedReader);

		FileWriter fileWriter = new FileWriter("/home/wang/桌面/2.java");

		String line = null;
		while ((line = wrapper.readLine()) != null) {
			fileWriter.write(line + "\r\n");
		}

		fileWriter.close();
		wrapper.close();
		bufferedReader.close();
	}
}
