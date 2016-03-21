$().ready(function(){
    $("div").unbind("click");
    $("div").bind("click", function(){
        $(this).trigger("wang", {
            aa: 'aa',
            bb: 'bb'
        });
    });
    
    $("div").unbind("wang");
    $("div").bind("wang", function(event,json){
        alert(json.aa);
		alert(json.bb);
    });
});
