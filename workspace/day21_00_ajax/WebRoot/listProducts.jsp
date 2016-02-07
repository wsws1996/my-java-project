<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'listProducts.jsp' starting page</title>
    <style type="text/css">
    	.odd{
    		background-color: #c3f3c3;
    	}
    	.even{
    		background-color: #f3c3f3;
    	}
    </style>
  </head>
  
  <body>
	<table border="1" width="438">
		<tr>
			<th>编号</th>
			<th>名称</th>
			<th>单价</th>
		</tr>
		<c:forEach items="${products}" var="p" varStatus="vs">
			<tr class="${vs.index%2==0?'odd':'even'}">
			<td>${p.id }</td>
			<td>${p.name}</td>
			<td>${p.price}</td>
		</tr>
		</c:forEach>
	</table>
  </body>
</html>
