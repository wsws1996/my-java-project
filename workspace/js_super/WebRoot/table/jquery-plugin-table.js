(function($){
    $.fn.GridPanel = {
        initEvent: function(){
            $("#" + $.fn.GridPanel.defaultConfig.table_id).delegate("a", "click", function(){
                if ($(this).text() == "删除") {
                    $.fn.GridPanel.method.deleteRow.call(this);
                }
            });
            $("#" + $.fn.GridPanel.defaultConfig.table_id).delegate("input", "blur", function(){
                $.fn.GridPanel.method.updateCell.call(this);
            });
            $("#" + $.fn.GridPanel.defaultConfig.table_id).delegate("td:not(:has(a))", "click", function(){
                if ($(this).children("input").length == 0) {
                    var value = $(this).text();
                    $(this).empty();
                    var $txt = $.fn.GridPanel.method.createText();
                    $(this).append($txt);
                    $txt.focus();
                    $txt.attr("value", value);
                }
            });
        },
        defaultConfig: {
            table_id: '',
            url: '',
            option: {
                query: {
                    method: ''
                },
                del: {
                    method: '',
                    pid: ''
                }
            },
            fields: '',
            fieldUpdate: '',
            fieldDelete: ''
        },
        method: {
            createTable: function(config){
                $.extend(true, $.fn.GridPanel.defaultConfig, config);
                $.fn.GridPanel.initEvent();
                $.post($.fn.GridPanel.defaultConfig.url, $.fn.GridPanel.defaultConfig.option.query, function(data){
                    var array = eval("(" + data + ")");
                    $.each(array, function(){
                        $("#" + $.fn.GridPanel.defaultConfig.table_id + " tbody").append($.fn.GridPanel.method.createTR.call(this));
                    });
                });
            },
            addRow: function(){
            
            },
            deleteRow: function(){
                var delObj = $(this);
                if (window.confirm("您确认要删除吗？")) {
                    $.fn.GridPanel.defaultConfig.option.del.pid = $(this).parent().parent().data("id");
                    $.post($.fn.GridPanel.defaultConfig.url, $.fn.GridPanel.defaultConfig.option.del, function(data){
                        delObj.parent().parent().remove();
                    });
                    
                }
            },
            updateCell: function(){
                var updateObj = $(this);
                var pid = $(this).parent().parent().data("id");
                var value = $(this).val();
                var $td = $(this).parent();
                var item = $td.attr("item");
                $.post($.fn.GridPanel.defaultConfig.url, {
                    pid: pid,
                    item: item,
                    value: value,
                    method: 'updateColumn'
                }, function(data){
                    updateObj.remove();
                    $td.text(value);
                });
            },
            createTR: function(){
                var jsonObj = this;
                var $tr = $("<tr/>");
                $tr.data("id", jsonObj.pid);
                $.each($.fn.GridPanel.defaultConfig.fields, function(){
                    $tr.append($.fn.GridPanel.method.createTD.call(this, jsonObj));
                });
                return $tr;
            },
            createTD: function(jsonObj){
                if ($(this).attr("field") == $.fn.GridPanel.defaultConfig.fieldDelete) {
                    return $("<td/>").append($.fn.GridPanel.method.createA("删除"));
                }
                else 
                    if ($(this).attr("field") == $.fn.GridPanel.defaultConfig.fieldUpdate) {
                        return $("<td/>").append($.fn.GridPanel.method.createA("修改"));
                    }
                    else {
                        return $("<td/>").attr("item", $(this).attr("field")).text(jsonObj[$(this).attr("field")]);
                    }
            },
            createA: function(text){
                return $("<a/>").css("cursor", "pointer").text(text);
            },
            createText: function(){
                return $("<input>").attr("type", "text");
            }
        }
    };
})($);
