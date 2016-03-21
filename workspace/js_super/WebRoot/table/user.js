$().ready(function(){
    $.nameSpace("org.wang.Person");
    $.extend(org.wang.Person, $.fn.GridPanel);
    org.wang.Person.method.createTable({
        table_id: 'usertable',
        url: '../PersonServlet',
        fields: $("#usertable *[field]"),
        option: {
            query: {
                method: 'query'
            },
            del: {
                method: 'deleteById'
            }
        },
        fieldUpdate: 'update',
        fieldDelete: 'del'
    });
});
