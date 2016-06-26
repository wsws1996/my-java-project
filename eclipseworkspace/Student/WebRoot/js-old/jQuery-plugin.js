$.fn.extend({
    datagrid : function(object) {
        var columns = object.columns;
        var tr = "<tr>";
        for (var i = 0; i < columns.length; i++) {
            tr += "<td>" + columns[i].title + "</td>";
        };
        tr += "</tr>";
        $(this).append(tr);
        $.ajax({
            url : object.url,
            type : object.method,
            success : function(data) {
                var rows = data.rows;
                for (var i = 0; i < rows.length; i++) {
                    var tr1 = "<tr>";
                    tr1 += "<td>" + rows[i].checi + "</td>";
                    tr1 += "<td>" + rows[i].startstate + "</td>";
                    tr1 += "<td>" + rows[i].starttime + "</td>";
                    tr1 += "<td>" + rows[i].swz + "</td>";
                    tr1 += "<td>" + rows[i].tdz + "</td>";
                    tr1 += "<td>" + rows[i].bz + "</td>";
                    tr1 += "</tr>";
                    $("#datagrid").append(tr1);
                };
                //$(this).append(tr1);
            }
        });
    }
})
