package cn.wang.web.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 953926755115253309L;

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filename = request.getParameter("filename");
//		filename = new String(filename.getBytes("iso8859-1"), "UTF-8");
		String path = makePath(filename,
				this.getServletContext().getRealPath("/WEB-INF/upload"));
		File file = new File(path + "/" + filename);
		if (!file.exists()) {
			request.setAttribute("message", "您要下载的资源已经被删除");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}
		String realname = filename.substring(filename.indexOf("_") + 1);
		response.setHeader("content-disposition", "attachment;filename="
		+new String(realname.getBytes("UTF-8"), "iso8859-1"));//火狐中文文件名
//				+ URLEncoder.encode(realname, "UTF-8"));//ie中文文件名

		FileInputStream inputStream = new FileInputStream(file);
		OutputStream outputStream = response.getOutputStream();
		byte buffer[] = new byte[1024];
		int len = 0;
		while ((len = inputStream.read(buffer)) > 0) {
			outputStream.write(buffer, 0, len);
		}
		inputStream.close();
		outputStream.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	public String makePath(String filename, String savePath) {

		int hashcode = filename.hashCode();
		int dir1 = hashcode & 0xf;
		int dir2 = (hashcode & 0xf0) >> 4;
		String dir = savePath + "/" + dir1 + "/" + dir2;
		File file = new File(dir);
		if (!file.exists()) {
			file.mkdirs();
		}
		return dir;
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
