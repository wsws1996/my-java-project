<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/manage/header.jsp" %>
	<form action="${pageContext.request.contextPath}/manage/ManageServlet?op=addCategory" method="post">
		<table border="1">
			<tr>
				<td>*分类名称：</td>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td>描述：</td>
				<td>
					<textarea rows="3" cols="38" name="description">
						
					</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="保存" onclick="toSubmit()"/>
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		function toSubmit() {
			var nameValue=document.getElementById("name").value;
			if (nameValue.trim()=="") {
				alert("请输入分类名称");
				return;
			}
			document.forms[0].submit();
		}
	</script>
</body>
</html>
