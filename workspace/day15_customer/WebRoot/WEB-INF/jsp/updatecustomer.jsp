<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>更新用户</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/customer.js"></script>
</head>

<body onload="pageInit()">
	<form
		action="${pageContext.request.contextPath}/servlet/UpdateCustomerServlet"
		method="post" onsubmit="return dosubmit()" id="customer">
		<input type="hidden" name="id" value="${customer.id}">

		<table width="100%">
			<tr>
				<td>客户姓名</td>
				<td><input type="text" name="name" value="${customer.name}"></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="radio" name="gender" value="男"
					${customer.gender=='男'?'checked': ''}>男 <input type="radio"
					name="gender" value="女" ${customer.gender=='女'?'checked':'' }>女</td>
			</tr>
			<tr>
				<td>生日</td>
				<td><select id="year">
						<option value="${fn:split(customer.birthday,'-')[0]}">${fn:split(customer.birthday,'-')[0]}</option>
				</select>年 <select id="month">
						<option value="${fn:split(customer.birthday,'-')[1]}">${fn:split(customer.birthday,'-')[1]}</option>
				</select>月 <select id="day">
						<option value="${fn:split(customer.birthday,'-')[2]}">${fn:split(customer.birthday,'-')[2]}</option>
				</select>日</td>
			</tr>
			<tr>
				<td>手机</td>
				<td><input type="text" name="cellphone"
					value="${customer.cellphone}"></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" name="email" value="${customer.email}"></td>
			</tr>
			<tr>
				<td>爱好</td>
				<td><c:forEach var="pre" items="${preferences}">
						<input type="checkbox" name="pre" value="${pre}"
							${fn:contains(customer.preference,pre)?'checked':'' }>${pre}
				</c:forEach></td>
			</tr>
			<tr>
				<td>客户类型</td>
				<td><c:forEach var="type" items="${types}">
						<input type="radio" name="type" value="${type }"
							${customer.type==type?'checked':'' }>${type }
				</c:forEach></td>
			</tr>
			<tr>
				<td>客户备注</td>
				<td><textarea rows="5" cols="30" name="description">${customer.description }</textarea>
				</td>
			</tr>
			<tr>
				<td><input type="reset" value="清空"></td>
				<td><input type="submit" value="修改客户"></td>
			</tr>
		</table>
	</form>
</body>
</html>
