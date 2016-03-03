<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/header.jsp"%>
<c:if test="${empty sessionScope.cart.items}">
	<h3>您没有购买任何商品</h3>
</c:if>
<c:if test="${!empty sessionScope.cart.items}">
	<h2>您购买的商品如下：</h2>
	<table border="1">
		<tr>
			<th>书名</th>
			<th>数量</th>
			<th>单价</th>
			<th>小计</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${sessionScope.cart.items}" var="me" varStatus="vs">
			<tr class="${vs.index%2==0?'odd':'even'}">
				<td>${me.value.book.name}</td>
				<td><input type="text" id="quantity"
					value="${me.value.quantity}" size="2"
					onchange="changeNum(this,${me.value.quantity},'${me.value.book.id}')"></td>
				<td>${me.value.book.price}</td>
				<td>${me.value.money}</td>
				<td><a href="javascript:delOneItem('${me.key}')">删除</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><a href="javascript:delAllItems()">清空购物车</a>
				总数量：${sessionScope.cart.totalQuntity}本
				应付金额：${sessionScope.cart.totalMoney}元
				<a href="${pageContext.request.contextPath}/client/ClientServlet?op=genOrder">去结算</a>
			</td>
		</tr>
	</table>
</c:if>
<script type="text/javascript">
	function delAllItems() {
		var sure = window.confirm("确定要清空购物车吗？");
		if (sure) {
			window.location.href = "${pageContext.request.contextPath}/client/ClientServlet?op=delAllItems";
		}
	}
	function delOneItem(bookId) {
		var sure = window.confirm("确定要删除该项吗？");
		if (sure) {
			window.location.href = "${pageContext.request.contextPath}/client/ClientServlet?op=delOneItem&bookId="
					+ bookId;
		}
	}
	function changeNum(inputObj, oldNum, bookId) {
		var sure = window.confirm("确定要修改数量吗？");
		if (sure) {
			var num = inputObj.value;
			if (!/^[1-9][0-9]*$/.test(num)) {
				alert("请输入正确的数量");
				inputObj.value = oldNum;
				return;
			}
			window.location.href = "${pageContext.request.contextPath}/client/ClientServlet?op=changeNum&bookId="
					+ bookId + "&num=" + num;
		} else {
			inputObj.value = oldNum;
		}
	}
</script>
</body>
</html>
