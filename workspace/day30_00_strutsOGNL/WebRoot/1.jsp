<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>OGNL基本功能</title>

</head>

<body>
	<s:property value="'abcdefg'.length()"/><br>
	<s:property value="@java.lang.Integer@MAX_VALUE"/><br>
	<s:property value="@java.lang.Math@abs(-100)"/>
</body>
</html>
