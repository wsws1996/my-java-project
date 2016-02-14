<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/header.jsp"%>
<table>
	<tr>
		<th>订单编号</th>
		<th>数量</th>
		<th>金额</th>
		<th>状态</th>
		<th>明细</th>
	</tr>
	<c:forEach var="o" varStatus="vs" items="${os}">
		<tr class="${vs.index%2==0?'odd':'even'}">
			<td>${o.ordernum}</td>
			<td>${o.quantity }</td>
			<td>${o.money }</td>
			<td>
				<c:choose>
					<c:when test="${o.status==0}">
						未付款<a href="${pageContext.request.contextPath}/pay.jsp?ordernum=${o.ordernum}&money=${o.money}">去付款</a>
					</c:when>
					<c:when test="${o.status==1}">
						已付款
					</c:when>
					<c:when test="${o.status==2}">
						已发货
					</c:when>
				</c:choose>
			</td>
			<td>
				<a href="">查看明细</a>
			</td>
		</tr>
	</c:forEach>
</table>