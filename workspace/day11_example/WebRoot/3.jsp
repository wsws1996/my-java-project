<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/wang"  prefix="wang"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>if......else标签</title>

</head>

<body>
	<wang:choose>
		<wang:when test="${user!=null }">
			xxx
		</wang:when>
		<wang:otherwise>
			yyy
		</wang:otherwise>
	</wang:choose>
</body>
</html>
