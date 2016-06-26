<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>学生成绩管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<!--jquery  easyui 的主文件...-->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.easyui.min.js"></script>
<!--jQuery 的主样式文件...-->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/js/themes/default/easyui.css">
<!--
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/js/themes/bootstrap/easyui.css">-->
<!--jQuery 的图标文件...-->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/js/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
	$(function() {
		wang.init.pageUI();

	})

	var wang = {
		init : {
			pageUI : function() {
				$("#jeasyUItree")
						.tree(
								{
									data:[
									  	{
											"id": "info",
											"text": "学生信息管理",
											"iconCls": "icon-info",
											"children": [
												{
													"id": "queryStudentUI",
													"text": "学生信息查询",
													"iconCls": "icon-search"
												}
											]
										}
									],
									dnd : true,
									animate : true,
									lines : true,
									onClick : function(node) {
										var tabs = $("#center_tab").tabs(
												"getTab", node.text);
										if (node.text == "学生信息管理"
												|| node.text == "学生成绩管理") {
											return;
										}
										if (tabs) {
											$("#center_tab").tabs("select",
													node.text)

										} else {
											//添加面板...
											$("#center_tab")
													.tabs(
															'add',
															{
																title : node.text,
																closable : true,
																href : "${pageContext.request.contextPath }/"
																		+ node.id+".action"
															});
										}
									}
								})

			}
		}
	}
</script>



</head>

<body class="easyui-layout">
	<div data-options="region:'west',title:'功能菜单',split:true"
		style="width: 250px;">
		<div id="leftaccording" class="easyui-accordion"
			data-options="fit:true">
			<div title="学生成绩管理系统"
				data-options="iconCls:'icon-manage',selected:true"
				style="overflow: auto; padding: 10px;">
				<ul id="jeasyUItree"></ul>
			</div>
		</div>


	</div>

	<div data-options="region:'center',title:'欢迎使用'" style="padding: 5px;">
		<div id="center_tab" class="easyui-tabs" data-options="fit:true"
			style="width: 500px; height: 250px;">
			<div title="欢迎进入" style="padding: 10px;">
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td align="center"><img src="welcome.gif" width="145"
							height="46" /></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<div
		data-options="region:'south',title:'Copyright © 2016 All Rights Reserved. 版权所有',split:true"
		style="height: 30px;"></div>
</body>

</html>