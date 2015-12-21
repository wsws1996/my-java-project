<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="/wang"  prefix="wang"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>显示所有用户</title>

</head>

<body style="text-align:  center;">
	<c:choose>
		<c:when test="${!empty(page.list)}">
			<table border="1" style="margin: auto;">
				<tr>
					<td align="center">客户姓名</td>
					<td align="center">性别</td>
					<td align="center">生日</td>
					<td align="center">手机号码</td>
					<td align="center">邮箱</td>
					<td align="center">爱好</td>
					<td align="center">类型</td>
					<td align="center">备注</td>
					<td align="center">操作</td>
				</tr>
				<c:forEach var="c" items="${page.list}">
					<tr>
						<td align="center"><c:out value="${c.name}"></c:out></td>
						<td align="center"><c:out value="${c.gender}"></c:out></td>
						<td align="center"><c:out value="${c.birthday}"></c:out></td>
						<td align="center"><c:out value="${c.cellphone }"></c:out></td>
						<td align="center"><c:out value="${c.email }"></c:out></td>
						<td align="center"><c:out value="${wang:subString(c.preference,10)}"></c:out></td>
						<td align="center"><c:out value="${c.type }"></c:out></td>
						<td align="center"><c:out
								value="${wang:subString(c.description,10)}"></c:out></td>
						<td align="center"><a href="${pageContext.request.contextPath}/servlet/UpdateCustomerUIServlet?id=${c.id}">修改</a> <a href="#">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			<%--当前第[${page.pagenum}]页&nbsp;&nbsp;&nbsp;&nbsp;
			<c:if test="${page.pagenum>1 }">
				<a
					href="${pageContext.request.contextPath }/servlet/ListCustomerServlet?pagenum=${page.pagenum-1}">上一页</a>
			</c:if>
			<c:forEach var="pagenum" begin="${page.startPage }"
				end="${page.endPage}">[
				<a
					href="${pageContext.request.contextPath }/servlet/ListCustomerServlet?pagenum=${pagenum}">${pagenum}</a>]
			</c:forEach>
			<c:if test="${page.pagenum<page.totalpage }">
				<a
					href="${pageContext.request.contextPath }/servlet/ListCustomerServlet?pagenum=${page.pagenum+1}">下一页</a>
			</c:if>
			&nbsp;&nbsp;&nbsp;&nbsp;
			共[${page.totalpage}]页，[${page.totalrecord}]条记录
			<input type="text" style=" width: 30px;" id="pagenum">
			<input type="button" value="GO"
				onclick="goWitch(document.getElementById('pagenum'))">
			<script type="text/javascript">
				function goWitch(input) {
					var pagenum = input.value;
					if (pagenum == null || pagenum == "") {
						alert("请输入页码！");
						return;
					}
					if (!pagenum.match("\\d+")) {
						alert("请输入数字！");
						input.value="";
						return;
					}
					if (pagenum<1||pagenum>${page.totalpage}) {
						alert("无效的页码！");
						input.value="";
						return;
					}
					window.location.href = "${pageContext.request.contextPath }/servlet/ListCustomerServlet?pagenum="
							+ pagenum;
				}
			</script> --%>
			<%@include file="/public/page.jsp"%>
		</c:when>
		<c:otherwise>
			对不起，系统还没有任何客户信息！！！
		</c:otherwise>
	</c:choose>
</body>
</html>
