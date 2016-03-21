$().ready(function(){
	
    $("body").delegate("div", "click", function(){
 		alert($(this).text());   
    });
    $("input[type='button']").unbind("click");
    $("input[type='button']").bind("click", function(){
        $("body").append($("<div/>").text("fhj"));
    });
    for (var i = 0; i < 3; i++) {
        //        $("div").click(function(){
        //   			alert("aaa")     
        //        });
        //        $("div").unbind("click");
        //        $("div").bind("click", function(){
        //            alert("fgh");
        //        });
    }
});
