<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

当前第[${page.pagenum}]页&nbsp;&nbsp;&nbsp;&nbsp;
<c:if test="${page.pagenum>1 }">
	<a
		href="${page.url}?pagenum=${page.pagenum-1}">上一页</a>
</c:if>
<c:forEach var="pagenum" begin="${page.startPage }"
	end="${page.endPage}">[
				<a
		href="${page.url}?pagenum=${pagenum}">${pagenum}</a>]
			</c:forEach>
<c:if test="${page.pagenum<page.totalpage }">
	<a
		href="${page.url}?pagenum=${page.pagenum+1}">下一页</a>
</c:if>
&nbsp;&nbsp;&nbsp;&nbsp; 共[${page.totalpage}]页，[${page.totalrecord}]条记录
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
			input.value = "";
			return;
		}
		if (pagenum<1||pagenum>${page.totalpage}) {
			alert("无效的页码！");
			input.value = "";
			return;
		}
		window.location.href = "${page.url}?pagenum="
				+ pagenum;
	}
</script>