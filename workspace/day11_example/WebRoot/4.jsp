<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/wang" prefix="wang"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>foreach 标签</title>

</head>

<body>
	<%
		List list = new ArrayList();
		list.add("a");
		list.add("b");
		request.setAttribute("list", list);
	%>
	<wang:foreach var="str" items="${list }">
	${str}
	</wang:foreach>

	<br>
	<hr>
	<br>
	<br>

	<%
		list = new ArrayList();
		list.add("a");
		list.add("b");
		request.setAttribute("list", list);
		Integer arr[] = new Integer[] { 1, 2, 3 };
		request.setAttribute("arr", arr);
		Map map = new HashMap();
		map.put("a", "aaaaa");
		map.put("b", "bbbbb");
		request.setAttribute("map", map);
	%>
	<wang:foreach2 items="${list }" var="str">
		${str }
	</wang:foreach2>
	<br>
	<hr>
	<br>
	<br>
	<wang:foreach2 items="${arr }" var="num">
		${num }
	</wang:foreach2>
	<br>
	<hr>
	<br>
	<br>
	<wang:foreach2 items="${map }" var="me">
		${me.key }=${me.value }<br>
	</wang:foreach2>
	<br>
	<hr>
	<br>
	<br>
	<%
		int i[] = new int[] { 1, 2, 3 };
		 byte b[] =new byte[]{3,2,1};
		request.setAttribute("b", b);
	%>
	<wang:foreach2 items="${b}" var="num">
		${num }
	</wang:foreach2>
</body>
</html>
