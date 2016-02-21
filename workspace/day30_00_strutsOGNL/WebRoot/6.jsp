<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP '6.jsp' starting page</title>

</head>

<body>
	<s:property value="#request.p1"/><hr>
	<s:property value="g"/><hr>
	${p1}
	${pp2 }
	<s:debug></s:debug>
</body>
</html>
