package cn.wang.context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextDemo6 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	public void test4() throws IOException {
		InputStream inputStream= this.getServletContext().getResourceAsStream("/db.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		System.out.println(driver);
	}

	public void test3() throws FileNotFoundException, IOException {
		String path = this.getServletContext().getRealPath(
				"/WEB-INF/classes/db.properties");
		FileInputStream inputStream=new FileInputStream(new File(path));
		Properties properties = new Properties();
		properties.load(inputStream);
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		System.out.println(driver);
	}

	public void test2() throws IOException {
		InputStream inputStream = this.getServletContext().getResourceAsStream(
				"/WEB-INF/classes/db.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		System.out.println(driver);
	}

	public void test1() throws FileNotFoundException {
		FileInputStream fileInputStream = new FileInputStream("db.properties");
		System.out.println(fileInputStream);
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
