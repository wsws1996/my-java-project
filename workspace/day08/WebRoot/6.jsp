<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.nio.file.Path"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = application.getRealPath("/1.jpg");
	String filename = path.substring(path.lastIndexOf("/") + 1);
	response.setHeader("content-disposition", "attachment;filename="
			+ filename);
	FileInputStream fileInputStream = new FileInputStream(path);
	int len = 0;
	byte buffer[] = new byte[1024];
	OutputStream outputStream = response.getOutputStream();
	while ((len = fileInputStream.read(buffer)) > 0) {
		outputStream.write(buffer, 0, len);
	}

	out.clear();
	out = pageContext.pushBody();
%>