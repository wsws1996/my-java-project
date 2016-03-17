$().ready(function(){
    queryPerson();
});

function queryPerson(){
    $.post("../../PersonServlet", null, function(data){
        var jsonObj = eval("(" + data + ")");
        for (var i = 0; i < jsonObj.length; i++) {
            var name = jsonObj[i].name;
            var description = jsonObj[i].description;
            var pid = jsonObj[i].pid;
            
            var $checkBoxTD = $("<td/>").prop("id", pid).append($("<input/>").prop("type", "checkbox"));
            var $nameTD = $("<td/>").text(name);
            var $descriptionTD = $("<td/>").text(description);
            
            var $delA = $("<a/>").text("删除");
            var $delTD = $("<td/>").append($delA);
            
            var $updateA = $("<a/>").text("修改");
            var $updateTD = $("<td/>").append($updateA);
            var $tr = $("<tr/>").append($checkBoxTD).append($nameTD).append($descriptionTD).append($delTD).append($updateTD);
            $("#usertable tbody").append($tr);
        }
    })
}
