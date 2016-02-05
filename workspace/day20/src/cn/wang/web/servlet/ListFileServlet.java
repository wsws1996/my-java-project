package cn.wang.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListFileServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2152742661316925469L;

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filepath = this.getServletContext()
				.getRealPath("/WEB-INF/upload");
		Map<String, String> map = new HashMap<String, String>();
		listfile(new File(filepath), map);
		
		request.setAttribute("map", map);
		request.getRequestDispatcher("/listfile.jsp").forward(request, response);
	}

	public void listfile(File file, Map<String, String> map) {
		if (!file.isFile()) {
			File files[] = file.listFiles();
			for (File f : files) {
				listfile(f, map);
			}
		} else {
			String realname = file.getName().substring(
					file.getName().indexOf("_") + 1);
			map.put(file.getName(), realname);
		}
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
