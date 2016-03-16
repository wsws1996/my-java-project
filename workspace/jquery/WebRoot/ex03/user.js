$().ready(function(){
    var index = 1;
    $("#addUser").click(function(){
        var name = $("#name").val();
        var email = $("#email").val();
        var tel = $("#tel").val();
        
        var $checkbox = $("<input/>").attr("type", "checkbox");
        var $checkboxTD = $("<td/>").append($checkbox);
        $checkboxTD.attr("id", index);
        index++;
        
        var $nameTD = $("<td/>").text(name);
        
        var $emailTD = $("<td/>").text(email);
        
        var $phoneTD = $("<td/>").text(tel);
        
        var $updateA = $("<a/>").text("修改");
        
        $updateA.css("cursor", "pointer");
        
        $updateA.click(function(){
            var name = $(this).parent().siblings("td:eq(1)").text();
            var email = $(this).parent().siblings("td:eq(2)").text();
            var tel = $(this).parent().siblings("td:eq(3)").text();
            var id = $(this).parent().siblings("td:eq(0)").attr("id");
            
            $("#name_update").val(name);
            $("#email_update").val(email);
            $("#tel_update").val(tel);
            $("#id_update").val(id);
        });
        
        var $updateTD = $("<td/>").append($updateA);
        
        var $delA = $("<a/>").text("删除");
        
        $delA.css("cursor", "pointer");
        $delA.click(function(){
            if (window.confirm("您确认要删除吗?")) {
                $(this).parent().parent().remove();
            }
        });
        var $delTD = $("<td/>").append($delA);
        
        var $tr = $("<tr/>").append($checkboxTD).append($nameTD).append($emailTD).append($phoneTD).append($delTD).append($updateTD);
        
        $("#usertable tbody").append($tr);
    });
    $("#deleteUser").click(function(){
        if (window.confirm("您确认要删除吗？")) {
            $("tbody :checkbox:checked:not(#allCheckbox)").parent().parent().remove();
        }
    });
    $("#allCheckbox").click(function(){
        if ($(this).prop("checked")) {
            $("tbody :checkbox").prop("checked", true);
        }
        else {
            $("tbody :checkbox").prop("checked", false);
        }
    });
    $("#updateUser").click(function(){
        var idValue = $("#id_update").val();
        var name_update = $("#name_update").val();
        var email_update = $("#email_update").val();
        var tel_update = $("#tel_update").val();
        $("td[id=" + idValue + "]").siblings("td:eq(0)").text(name_update);
        $("td[id=" + idValue + "]").siblings("td:eq(1)").text(email_update);
        $("td[id=" + idValue + "]").siblings("td:eq(2)").text(tel_update);
    });
});
