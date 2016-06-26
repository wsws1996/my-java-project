var menu = {
    setting: {
        isSimpleData: true,
        treeNodeKey: "mid",
        treeNodeParentKey: "pid",
        showLine: true,
        root: {
            isRoot: true,
            nodes: []
        }
    },
    loadMenuTree: function(){
        $.post("elecMenuAction_showMenu.do", {}, function(privilegeDate){
            $("#menuTree").zTree(menu.setting, privilegeDate);
        });
    }
};

$(document).ready(function(){
    menu.loadMenuTree();
});
