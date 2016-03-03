<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>单文件上传</title>
    
  </head>
  
  <body>
  	<s:actionerror/>
  	<s:form action="uploadSingleFile" enctype="multipart/form-data" method="post">
  	<s:textfield name="name" label="名称"></s:textfield>
  	<s:file name="photo" label="照片"></s:file>
  	<s:submit value="上传"></s:submit>
  	</s:form>
  </body>
</html>
