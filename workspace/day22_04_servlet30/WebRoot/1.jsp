<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>文件上传</title>
    
  </head>
  
  <body>
	<form action="${pageContext.request.contextPath}/servlet/ServletDemo3" method="post" enctype="multipart/form-data">
		name:<input type="text" name="name"/><br>
		file:<input type="file" name="file"/><br>
		<input type="submit" value="上传">
	</form>
  </body>
</html>
