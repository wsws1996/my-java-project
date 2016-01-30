package cn.wang.web.Wrappers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class BufferResponse extends HttpServletResponseWrapper {

	private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

	private HttpServletResponse response;

	private PrintWriter printWriter;

	public BufferResponse(HttpServletResponse response) {
		super(response);
		this.response = response;
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		return new MyServletOutputStream(byteArrayOutputStream);
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		printWriter = new PrintWriter(new OutputStreamWriter(
				byteArrayOutputStream, response.getCharacterEncoding()));
		return printWriter;
	}

	public byte[] getBuffer() {
		try {
			if (printWriter != null) {
				printWriter.close();
			}
			if (byteArrayOutputStream != null) {
				byteArrayOutputStream.flush();
				return byteArrayOutputStream.toByteArray();
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

class MyServletOutputStream extends ServletOutputStream {

	private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

	public MyServletOutputStream(ByteArrayOutputStream byteArrayOutputStream) {
		this.byteArrayOutputStream = byteArrayOutputStream;
	}

	@Override
	public void write(byte[] b) throws IOException {//该方法内部也是调用 public void write(int b) 方法,因此该方法可以不被复写
		this.byteArrayOutputStream.write(b);
	}

	@Override
	public void write(int b) throws IOException {
		this.byteArrayOutputStream.write(b);
	}

}
