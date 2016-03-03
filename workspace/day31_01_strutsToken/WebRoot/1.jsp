<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP '1.jsp' starting page</title>

</head>

<body>
	<s:form action="register1">
		<s:textfield name="name" label="姓名"></s:textfield>
		<s:token></s:token>
		<s:submit value="保存"></s:submit>
		<s:debug></s:debug>
	</s:form>
</body>
</html>
