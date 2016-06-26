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
	function editStudent() {
		$('#fm').form({
			url : "${pageContext.request.contextPath }/editStudent.action",
			success : function(data) {

			}
		});
		var row = $("#mytable").datagrid("getSelected");
		if (row) {
			$("#dlg").dialog("open").dialog('setTitle', '学生信息修改');
			$("#fm").form("load", row);
		}
	}
	function delStudent() {
		var row = $("#mytable").datagrid("getSelected");
		if (row) {
			$.messager
					.confirm(
							'提示框',
							'你确定要删除吗?',
							function(b) {
								if (b) {
									$
											.post(
													"${pageContext.request.contextPath }/delStudent.action",
													{
														"xh" : row.xh
													}, function(data) {
													});
									FindData();
								}
							});
		}
	}

	function addStudent() {
		$('#fm').form({
			url : "${pageContext.request.contextPath }/addStudent.action",
			success : function(data) {

			}
		});
		$('#fm').form("clear");
		$("#dlg").dialog("open").dialog('setTitle', '学生信息录入');
	}
	function submitForm() {
		$("#fm").submit();
		$("#dlg").dialog("close");
		FindData();
	}
	function FindData() {
		$('#ff').form({
			url : "${pageContext.request.contextPath }/queryStudent.action",
			success : function(data) {
				$("#mytable").datagrid({
					columns : [ [ {
						"checkbox" : false
					}, {
						title : "学号",
						width : 150,
						field : 'xh'
					}, {
						title : "姓名",
						width : 100,
						field : 'xm'
					}, {
						title : "性别",
						width : 80,
						field : 'xb',
						formatter : function(value, row, index) {
							if (value == "0") {
								return "女";
							} else {
								return "男";
							}

						}
					}, {
						title : "出生时间",
						width : 200,
						field : 'cssj'
					}, {
						title : "专业",
						width : 100,
						field : 'zy'
					}, {
						title : "总学分",
						width : 100,
						field : 'zxf'
					}, {
						title : "成绩",
						width : 100,
						field : 'cj'
					}, {
						title : "备注",
						width : 200,
						field : 'bz'
					}, {
						title : "",
						width : 0,
						field : 'zp',
						hidden : true
					} ] ],
					fitColumns : true,
					data : eval('(' + data + ')'),
					toolbar : [ {
						text : "修改",
						iconCls : 'icon-edit',
						handler : function() {
							editStudent();
						}
					}, '-', {
						text : "删除",
						iconCls : 'icon-cancel',
						handler : function() {
							delStudent();
						}
					}, '-', {
						text : "添加",
						iconCls : 'icon-add',
						handler : function() {
							addStudent();
						}
					} ],
					loadMsg : "数据正在加载中....",
					method : "POST",
					rownumbers : true,
					singleSelect : true,
					striped : true
				});
			}
		});
		//提交表单 
		$('#ff').submit();
	}
</script>


<div id="searchtool" style="padding: 5px; width: 100%">
	<form action="" id="ff" method="post">
		<span>学号：</span><input class="easyui-textbox" style="width: 100px"
			name="xh"> <span>姓名：</span><input class="easyui-textbox"
			style="width: 100px" name="xm"> <span>性别：</span><input
			type="radio" name="xb" id="gender" value="1"> 男 <input
			type="radio" name="xb" id="gender" value="0"> 女 <span>出生时间：</span><input
			class="easyui-datebox" name="startDate" style="width: 100px">----
		<input class="easyui-datebox" name="endDate" style="width: 100px"><br>
		<span>专业：</span> <select id="cc" class="easyui-combobox" name="zy"
			style="width: 100px;">
			<option value="">请选择</option>
			<option value="计算机">计算机</option>
			<option value="通信工程">通信工程</option>
			<option value="网络工程">网络工程</option>
		</select> <span>总学分：</span> <input type="text" class="easyui-numberbox"
			data-options="min:0" name="zxf1" style="width: 100px;"></input>---- <input
			type="text" class="easyui-numberbox" data-options="min:0" name="zxf2"
			style="width: 100px;"> <a href="javascript:FindData()"
			class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
	</form>
	<div>
		<table id="mytable" style="width: 100%"></table>
		<div id="dlg" class="easyui-dialog"
			style="width: 400px; height: 280px; padding: 10px 20px;"
			closed="true" buttons="#dlg-buttons">
			<div class="ftitle">信息编辑</div>
			<form id="fm" method="post" action="">
				<div class="fitem">
					<label>学号：</label> <input name="xh" id="xh"
						class="easyui-validatebox" type="text" required="true" />
				</div>
				<div class="fitem">
					<label>姓名：</label> <input name="xm" class="easyui-validatebox"
						type="text" required="true" />
				</div>
				<div class="fitem">
					<label> 性别：</label> <input name="xb" type="radio" value="0"
						checked="checked" />女 <input name="xb" type="radio" value="1" />男
				</div>
				<div class="fitem">
					<label>出生时间：</label> <input id="dd" type="text"
						class="easyui-datebox" required="required" name="cssj"
						value="row.cssj"></input>
				</div>
				<div class="fitem">
					<label>专业：</label> <select id="cc" class="easyui-combobox"
						name="zy" style="width: 100px;">
						<option value="">请选择</option>
						<option value="计算机">计算机</option>
						<option value="通信工程">通信工程</option>
						<option value="网络工程">网络工程</option>
					</select>
				</div>
				<div class="fitem">
					<label>总学分：</label> <input id="vv" class="easyui-validatebox"
						data-options="required:true" name="zxf" />
				</div>
				<div class="fitem">
					<label>备注：</label> <input class="easyui-textbox" name="bz">
				</div>
			</form>
		</div>

		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="submitForm()" iconcls="icon-save">保存</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				onclick="javascript: $('#dlg').dialog('close')"
				iconcls="icon-cancel">取消</a>
		</div>