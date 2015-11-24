package cn.wang.context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextDemo7 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		test1();
	}

	public void test6() throws FileNotFoundException, IOException {
		String path = this.getServletContext().getRealPath(
				"/WEB-INF/classes/FriendsS01E01.mp4");
		String filename = path.substring(path.lastIndexOf("/") + 1);
		InputStream inputStream = this.getServletContext().getResourceAsStream(
				"/WEB-INF/classes/FriendsS01E01.mp4");
		byte buffer[] = new byte[1024];
		int len = 0;
		FileOutputStream outputStream = new FileOutputStream("/mnt/hgfs/E/"+filename);
		while ((len = inputStream.read(buffer)) > 0) {
			outputStream.write(buffer, 0, len);
		}
		outputStream.close();
		inputStream.close();
	}

	public void test5() {
		InputStream inputStream = ServletContextDemo7.class.getClassLoader()
				.getResourceAsStream("cn/wang/context/db.properties");
		System.out.println(inputStream);
	}

	public void test1() throws IOException {
		ClassLoader classLoader = ServletContextDemo7.class.getClassLoader();
		InputStream inputStream = classLoader
				.getResourceAsStream("db.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		System.out.println(driver);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
