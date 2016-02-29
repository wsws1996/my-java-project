package cn.wang.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet1 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 741514861673523080L;

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// request.getParameter("username")获取不到请求参数，因为multipart/form-data使得无法使用该方法获取参数
			String savePath = this.getServletContext().getRealPath(
					"/WEB-INF/upload");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(new File(this.getServletContext()
					.getRealPath("/WEB-INF/temp")));
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setProgressListener(new ProgressListener() {

				@Override
				public void update(long pBytesRead, long pContextLength,
						int arg2) {
//					System.out.println("文件大小为：" + pContextLength + "，当前已处理："
//							+ pBytesRead);
				}
			});
			upload.setHeaderEncoding("UTF-8");// 解决上传文件名乱码

			if (!ServletFileUpload.isMultipartContent(request)) {
				return;
			}
			// upload.setFileSizeMax(1024 * 1024);
			// upload.setSizeMax(1024 * 512 * 3);
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem fileItem : list) {
				if (fileItem.isFormField()) {
					String name = fileItem.getFieldName();
					String value = fileItem.getString("UTF-8");
					// request.setCharacterEncoding("UTF-8");//表单为文件上传，设置request编码无效,只能手工转换，或在getstring方法中指定码表
					// value = new String(value.getBytes("iso8859-1"), "UTF-8");
					System.out.println(name + ": " + value);
				} else {
					String filename = fileItem.getName();// 有的浏览器提交完整文件路径，有的只提交文件名，所以要分割
					if (filename == null || filename.trim().equals("")) {
						continue;
					}
					filename = filename
							.substring(filename.lastIndexOf("\\") + 1);
					InputStream inputStream = fileItem.getInputStream();
					String saveFileName = makeFileName(filename);

					String realSavePath = makePath(saveFileName, savePath);
					FileOutputStream outputStream = new FileOutputStream(
							realSavePath + "/" + saveFileName);
					byte buffer[] = new byte[1024];
					int len = 0;
					while ((len = inputStream.read(buffer)) > 0) {
						outputStream.write(buffer, 0, len);
					}
					inputStream.close();
					outputStream.close();
					fileItem.delete();// 删除临时文件
				}
			}
		} catch (FileUploadBase.FileSizeLimitExceededException e) {
			e.printStackTrace();
			request.setAttribute("message", "单个文件大小不能超过1M");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		} catch (FileUploadBase.SizeLimitExceededException e) {
			e.printStackTrace();
			request.setAttribute("message", "总文件大小不能超过1.5M");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String makeFileName(String filename) {
		return UUID.randomUUID().toString() + "_" + filename;
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
