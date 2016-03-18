var privilege = {
    setting: {
        isSimpleData: true,
        treeNodeKey: "id",
        treeNodeParentKey: "pid",
        showLine: false,
        root: {
            isRoot: true,
            nodes: []
        }
    },
	loadPrivilegeTree:function(){
		$.post("privilegeAction_showPrivilegeTree.action",null,function(data){
			$("#tree").zTree(privilege.setting, data);
		});
	}
};



$(document).ready(function(){
   	privilege.loadPrivilegeTree();
});
