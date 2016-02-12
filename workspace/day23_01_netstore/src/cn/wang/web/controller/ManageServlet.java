package cn.wang.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import cn.wang.commons.Page;
import cn.wang.domain.Book;
import cn.wang.domain.Category;
import cn.wang.service.BussinessService;
import cn.wang.service.impl.BussinessServiceImpl;
import cn.wang.util.IdGenertor;
import cn.wang.util.WebUtil;

public class ManageServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -419494778928698353L;
	private BussinessService service = new BussinessServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		if ("addCategory".equals(op)) {
			addCategory(request, response);
		} else if ("showAllCategory".equals(op)) {
			showAllCategory(request, response);
		} else if ("addBookUI".equals(op)) {
			addBookUI(request, response);
		} else if ("addBook".equals(op)) {
			addBook(request, response);
		} else if ("showPageBooks".equals(op)) {
			showPageBooks(request, response);
		}
	}

	protected void showPageBooks(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		Page page = service.findBookPageRecords(num);
		page.setUrl("/manage/ManageServlet?op=showPageBooks");
		request.setAttribute("page", page);
		request.getRequestDispatcher("/manage/listBooks.jsp").forward(request, response);
	}

	// 添加图书
	protected void addBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
			throw new RuntimeException("The form is not multipart/form-data");
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
		List<FileItem> items = new ArrayList<FileItem>();
		try {
			items = servletFileUpload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		Book book = new Book();
		for (FileItem item : items) {
			if (item.isFormField()) {
				processFormField(item, book);
			} else {
				processUploadField(item, book);
			}
		}
		service.addBook(book);
		response.sendRedirect(request.getContextPath() + "/common/message.jsp");
	}

	private void processUploadField(FileItem item, Book book) {
		String storeDirectory = getServletContext().getRealPath("/images");
		File rootDirectory = new File(storeDirectory);
		if (!rootDirectory.exists()) {
			rootDirectory.mkdirs();
		}
		// 获取文件名
		String filename = item.getName();
		if (filename != null) {
			filename = IdGenertor.getUUID() + "."
					+ FilenameUtils.getExtension(filename);
			book.setFilename(filename);
		}
		// 计算子目录
		String path = genChildDirectory(storeDirectory, filename);
		book.setPath(path);

		try {
			item.write(new File(storeDirectory, path + "/" + filename));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void processFormField(FileItem item, Book book) {
		try {
			String fieldName = item.getFieldName();
			String fieldValue = item.getString("UTF-8");
			BeanUtils.setProperty(book, fieldName, fieldValue);
			if ("categoryId".equals(fieldName)) {
				Category category = service.findCategoryById(fieldValue);
				book.setCategory(category);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// 查询所有分类，转向添加书籍页面
	protected void addBookUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Category> categories = service.findAllCategories();
		request.setAttribute("cs", categories);
		request.getRequestDispatcher("/manage/addBook.jsp").forward(request,
				response);
	}

	// 查询所有分类
	protected void showAllCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Category> categories = service.findAllCategories();
		request.setAttribute("cs", categories);
		request.getRequestDispatcher("/manage/listCategory.jsp").forward(
				request, response);
	}

	// 添加分类
	protected void addCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Category category = WebUtil.fillBean(request, Category.class);
		service.addCategory(category);
		response.sendRedirect(request.getContextPath() + "/common/message.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	private String genChildDirectory(String realPath, String fileName) {
		int hashCode = fileName.hashCode();
		int dir1 = hashCode & 0xf;
		int dir2 = (hashCode & 0xf0) >> 4;
		String str = dir1 + File.separator + dir2;
		File file = new File(realPath, str);
		if (!file.exists()) {
			file.mkdirs();
		}
		return str;
	}
}
