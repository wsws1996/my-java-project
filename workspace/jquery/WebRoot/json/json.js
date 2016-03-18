var json1 = {};

var json2 = {
    name: 'aaa',
    id: 1,
    aaa: function(){
        alert("dvfd");
    }
};

var json3 = {
    person: {
        id: 1,
        name: 'aa'
    }
};

var json4 = [{
    id: 1,
    name: 'aaa'
}, {
    id: 2,
    name: 'bbb'
}];

var json5 = {
    setPerson: function(){
    
    }
};

var json6 = {
    aaa: json4
};

//for (var i in json2) {
//    alert(i);
//    if (typeof json2[i] == "function") {
//        json2[i]();
//    }
//    else {
//        alert(json2[i]);
//    }
//};
//alert(json2["name"]);
json2["name"] = 1;
alert(json2["name"]);
