<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'register1.jsp' starting page</title>

</head>

<body>
	<s:form action="register" namespace="/customer">
		<s:textfield name="birthday" label="出生日期" required="true"
			requiredposition="left"></s:textfield>
		<s:submit value="添加"></s:submit>
	</s:form>
	<s:form action="edit" namespace="/customer">
		<s:textfield name="birthday" label="出生日期" required="true"
			requiredposition="left"></s:textfield>
		<s:submit value="修改"></s:submit>
	</s:form>
</body>
</html>
