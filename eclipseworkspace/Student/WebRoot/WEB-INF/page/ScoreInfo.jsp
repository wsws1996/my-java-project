<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<style type="text/css">
#fm {
	margin: 0;
	padding: 10px 30px;
}

.ftitle {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.fitem {
	margin-bottom: 5px;
}

.fitem label {
	display: inline-block;
	width: 80px;
}
</style>

<script type="text/javascript">
	function initScore() {
		var xh = $("#mytable").datagrid("getSelected").xh;
		$('#scoreInfo')
				.datagrid(
						{
							url : '${pageContext.request.contextPath }/queryScore.action?xh='
									+ xh,
							columns : [ [ {
								field : 'kch',
								title : '课程号',
								width : 100
							}, {
								field : 'kcm',
								title : '课程名',
								width : 100
							}, {
								field : 'xf',
								title : '学分',
								width : 100
							}, {
								field : 'cj',
								title : '成绩',
								width : 100
							}, ] ],
							fitColumns : true,
							toolbar : [ {
								text : "修改",
								iconCls : 'icon-edit',
								handler : function() {
									editScoreInfo();
								}
							}, '-', {
								text : "录入",
								iconCls : 'icon-add',
								handler : function() {
									addScoreInfo();
								}
							} ],
							loadMsg : "数据正在加载中....",
							method : "POST",
							rownumbers : true,
							singleSelect : true,
							striped : true
						});
	}
	function addScoreInfo() {
		$('#sfm').form({
			url : "${pageContext.request.contextPath }/addScoreInfo.action",
			success : function(data) {

			}
		});
		$('#sfm').form("clear");
		$("#sdlg").dialog("open").dialog('setTitle', '学生成绩录入');
		$("#sfm").form("load", {
			xh : $("#mytable").datagrid("getSelected").xh
		});
	}
	function editScoreInfo() {
		$('#sfm').form({
			url : "${pageContext.request.contextPath }/editScoreInfo.action",
			success : function(data) {

			}
		});
		var row = $("#scoreInfo").datagrid("getSelected");
		if (row) {
			$("#sdlg").dialog("open").dialog('setTitle', '学生成绩修改');
			$("#sfm").form("load", row);
			$("#sfm").form("load", {
				xh : $("#mytable").datagrid("getSelected").xh
			});
		}
	}
	function ssubmitForm() {
		$("#sfm").submit();
		$("#sdlg").dialog("close");
		initScore();
	}
</script>
<script type="text/javascript">
	initScore();
</script>
<table id="scoreInfo" style="width: 100%"></table>
<div id="sdlg" class="easyui-dialog"
	style="width: 400px; height: 280px; padding: 10px 20px;" closed="true"
	buttons="#sdlg-buttons">
	<div class="ftitle">成绩信息</div>
	<form id="sfm" method="post" action="">
		<div class="fitem">
			<label>课程名：</label><input id="kcm" class="easyui-combobox" name="kch"
				data-options="valueField:'kch',textField:'kcm',url:'${pageContext.request.contextPath }/queryKcb.action'" />
		</div>
		<div class="fitem">
			<label>成绩：</label><input name="cj" type="text"
				class="easyui-numberbox" value="100" data-options="min:0"></input>
		</div>
		<input type="hidden" name="xh" id="xh">
	</form>
</div>

<div id="sdlg-buttons">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		onclick="ssubmitForm()" iconcls="icon-save">保存</a> <a
		href="javascript:void(0)" class="easyui-linkbutton"
		onclick="javascript: $('#sdlg').dialog('close')" iconcls="icon-cancel">取消</a>
</div>
