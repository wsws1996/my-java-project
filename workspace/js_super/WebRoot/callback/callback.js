function ajaxFunction(){
    var xmlHttp;
    
    try {
        // Firefox, Opera 8.0+, Safari
        xmlHttp = new XMLHttpRequest();
    } 
    catch (e) {
        try {
            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
        } 
        catch (e) {
        
            try {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            } 
            catch (e) {
                alert("您的浏览器不支持AJAX！");
                return false;
            }
        }
    }
    return xmlHttp;
}

window.onload = function(){
    /*
     ajax("../AjaxServlet", "post", null, function(data){
     alert(data);
     })
     */
    ajax2({
        url: '../AjaxServlet',
        method: 'post',
        data: null,
        callback: function(data){
            alert(this);
        }
    });
}

function ajax(url, method, data, callback){
    var xmlHttp = ajaxFunction();
    xmlHttp.onreadystatechange = function(){
        if (xmlHttp.readyState == 4) {
            if (xmlHttp.status == 200 || xmlHttp.status == 304) {
                callback(xmlHttp.responseText);
            }
        }
    }
    xmlHttp.open(method, url, true);
    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xmlHttp.send("data=" + data);
}

function ajax2(ajaxJSON){
    var xmlHttp = ajaxFunction();
    xmlHttp.onreadystatechange = function(){
        if (xmlHttp.readyState == 4) {
            if (xmlHttp.status == 200 || xmlHttp.status == 304) {
                ajaxJSON.callback.call(window,xmlHttp.responseText);
            }
        }
    }
    xmlHttp.open(ajaxJSON.method, ajaxJSON.url, true);
    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xmlHttp.send("data=" + ajaxJSON.data);
}
