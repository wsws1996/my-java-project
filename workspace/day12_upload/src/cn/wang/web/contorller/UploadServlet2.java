package cn.wang.web.contorller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet2 extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		if (!upload.isMultipartContent(request)) {
			return;
		}
		try {
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				if (item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString();
					System.out.println(name + "=" + value);

				} else {
					String filename = item.getName();
					filename = filename
							.substring(filename.lastIndexOf("\\") + 1);
					InputStream inputStream = item.getInputStream();
					int len = 0;
					byte buffer[] = new byte[1024];

					String savepath = this.getServletContext().getRealPath(
							"/upload");
					FileOutputStream fileOutputStream = new FileOutputStream(
							savepath + "/" + filename);
					while ((len = inputStream.read(buffer)) > 0) {
						fileOutputStream.write(buffer, 0, len);
					}
					inputStream.close();
					fileOutputStream.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
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
