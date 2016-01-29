<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP '8.jsp' starting page</title>

</head>

<body>
	<jsp:forward page="/1.jsp">
		<jsp:param value="yyyy" name="xxx"/>
	</jsp:forward>
</body>
</html>
