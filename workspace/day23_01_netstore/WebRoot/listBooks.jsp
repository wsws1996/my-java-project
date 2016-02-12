<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/header.jsp"%>
<a href="${pageContext.request.contextPath}">所有分类：</a>
<c:forEach var="c" items="${cs}">
	<a href="${pageContext.request.contextPath}/client/ClientServlet?op=showCategoryBooks&categoryId=${c.id}">${c.name}</a>
</c:forEach>
<table>
	<tr>
	</tr>
	<c:forEach var="b" items="${page.records}">
		<td><img alt="${b.filename}"
			src="${pageContext.request.contextPath}/images/${b.path}/${b.filename}"><br>
			书名：${b.name}<br>
			作者：${b.author}<br>
			单价：${b.price}<br>
			<a href="">去看看</a>
		</td>
	</c:forEach>
	<tr>
		<td colspan="3"><%@include file="/common/page.jsp"%>
		</td>
	</tr>
</table>

</body>
</html>
