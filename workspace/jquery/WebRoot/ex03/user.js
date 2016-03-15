$().ready(function(){
	$("#addUser").click(function(){
		var name=$("#name").val();
		var email=$("#email").val();
		var tel=$("#tel").val();
		
		var $checkbox=$("<input/>").attr("type","checkbox");
		var $checkboxTD=$("<td/>").append($checkbox);  
		
		var $nameTD=$("<td/>").text(name);
		
		var $emailTD=$("<td/>").text(email);
		
		var $phoneTD=$("<td/>").text(tel);
		
		var $updateTD=$("<td/>").append($("<a/>").text("修改"));

		var $delTD=$("<td/>").append($("<a/>").text("删除"));
		
		var $tr=$("<tr/>").append($checkboxTD).append($emailTD).append($phoneTD).append($updateTD).append($delTD);		
		
		$("#usertable tbody").append($tr);
	});
});
