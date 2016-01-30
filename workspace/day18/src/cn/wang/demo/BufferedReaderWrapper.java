package cn.wang.demo;

import java.io.BufferedReader;
import java.io.IOException;

public class BufferedReaderWrapper extends BufferedReader {
	// private BufferedReader bufferedReader;
	private int linenum = 0;

	public BufferedReaderWrapper(BufferedReader reader) {
		super(reader);
		// this.bufferedReader = reader;
	}

	@Override
	public String readLine() throws IOException {
		String line = super.readLine();
		if (line == null) {
			return null;
		}
		linenum++;
		return linenum + ". " + line;
	}

}
