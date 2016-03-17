$().ready(function(){
    queryPerson();
    $("#deleteUser").click(function(){
        var checkedNodes = $(":checkbox:not(#allCheckbox):checked");
        var checkedStr = "";
        for (var i = 0; i < checkedNodes.length; i++) {
            if (i == checkedNodes.length - 1) {
                checkedStr = checkedStr + $(checkedNodes[i]).parent().attr("id");
            }
            else {
                checkedStr = checkedStr + $(checkedNodes[i]).parent().attr("id") + ",";
            }
        }
        $.post("../../PersonServlet", {
            method: 'deleteByIds',
            ids: checkedStr
        }, function(data){
            $(":checkbox:not(#allCheckbox):checked").parent().parent().remove();
        })
    });
    $("#addUser").click(function(){
        var name = $("#name").val();
        var description = $("#description").val();
        
        var id = $("td[id]:last").prop("id");
        id++;
        
        
        $.post("../../PersonServlet", {
            id: id,
            name: name,
            description: description,
            method: 'add'
        }, function(data){
        
            var $checkBoxTD = $("<td/>").prop("id", id).append($("<input/>").prop("type", "checkbox"));
            var $nameTD = $("<td/>").text(name);
            var $descriptionTD = $("<td/>").text(description);
            
            var $delA = $("<a/>").text("删除");
            $delA.css("cursor", "pointer");
            $delA.click(function(){
                if (window.confirm("您确认要删除吗？")) {
                    var a = $(this);
                    var pid = a.parent().siblings("td:first").attr("id");
                    $.post("../../PersonServlet", {
                        method: 'deleteById',
                        pid: pid
                    }, function(data){
                        a.parent().parent().remove();
                    });
                }
            });
            
            var $delTD = $("<td/>").append($delA);
            
            var $updateA = $("<a/>").text("修改");
            $updateA.css("cursor", "pointer");
            
            $updateA.click(function(){
                var name = $(this).parent().siblings("td:eq(1)").text();
                var description = $(this).parent().siblings("td:eq(2)").text();
                var id = $(this).parent().siblings("td:eq(0)").attr("id");
                
                $("#name_update").val(name);
                $("#description_update").val(description);
                $("#id_update").val(id);
            });
            
            var $updateTD = $("<td/>").append($updateA);
            var $tr = $("<tr/>").append($checkBoxTD).append($nameTD).append($descriptionTD).append($delTD).append($updateTD);
            $("#usertable tbody").append($tr);
        });
    });
    
    $("#updateUser").click(function(){
        var id = $("#id_update").val();
        var name = $("#name_update").val();
        var description = $("#description_update").val();
        $.post("../../PersonServlet", {
            method: 'update',
            id: id,
            name: name,
            description: description
        }, function(data){
            $("#" + id).siblings("td:eq(0)").text(name);
            $("#" + id).siblings("td:eq(1)").text(description);
        });
    });
    
});

function queryPerson(){
    $.post("../../PersonServlet", {
        method: 'query'
    }, function(data){
        var jsonObj = eval("(" + data + ")");
        for (var i = 0; i < jsonObj.length; i++) {
            var name = jsonObj[i].name;
            var description = jsonObj[i].description;
            var pid = jsonObj[i].pid;
            
            var $checkBoxTD = $("<td/>").prop("id", pid).append($("<input/>").prop("type", "checkbox"));
            var $nameTD = $("<td/>").text(name);
            var $descriptionTD = $("<td/>").text(description);
            
            var $delA = $("<a/>").text("删除");
            $delA.css("cursor", "pointer");
            $delA.click(function(){
                if (window.confirm("您确认要删除吗？")) {
                    var a = $(this);
                    var pid = a.parent().siblings("td:first").attr("id");
                    $.post("../../PersonServlet", {
                        method: 'deleteById',
                        pid: pid
                    }, function(data){
                        a.parent().parent().remove();
                    });
                }
            });
            
            var $delTD = $("<td/>").append($delA);
            
            var $updateA = $("<a/>").text("修改");
            $updateA.css("cursor", "pointer");
            
            $updateA.click(function(){
                var name = $(this).parent().siblings("td:eq(1)").text();
                var description = $(this).parent().siblings("td:eq(2)").text();
                var id = $(this).parent().siblings("td:eq(0)").attr("id");
                
                $("#name_update").val(name);
                $("#description_update").val(description);
                $("#id_update").val(id);
            });
            
            var $updateTD = $("<td/>").append($updateA);
            var $tr = $("<tr/>").append($checkBoxTD).append($nameTD).append($descriptionTD).append($delTD).append($updateTD);
            $("#usertable tbody").append($tr);
        }
    })
}
