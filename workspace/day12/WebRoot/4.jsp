<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/wang"  prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP '4.jsp' starting page</title>

</head>

<body>
<%
	List list=new ArrayList();
	list.add("a");
	request.setAttribute("list", list);
	int arr[]={1,2,3};
	request.setAttribute("arr", arr);
 %>
	${fn:filter("<a href=''>点点</a>",arr) }
	<a href=''>点点</a>
</body>
</html>
