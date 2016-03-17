$().ready(function(){
	$.post("../../AjaxPostServlet",null,function(data){
		alert(data);
	});
});
