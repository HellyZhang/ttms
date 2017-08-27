var zTree;
/**setting树的基本配置*/
var setting = {
		data:{
			simpleData : {
				enable : true,
				idKey : "id",  //节点数据中保存唯一标识的属性名称
				pIdKey : "parentId",  //节点数据中保存其父节点唯一标识的属性名称
				rootPId : null  //根节点id
			}
		}
} 
$(document).ready(function(){
	$(".form-horizontal").on("click",".text-parentType",load_parentType);
	$(".layer-anim").on("click",".btn-cancle,.btn-confirm",saveParentTreen);
	$("#editTypeForm").on("click",".btn-primary,.btn-warning",saveOrUpdateProductType);

});
/**显示上级分类树*/
function load_parentType(){
	var url ="productType/loadparentType.do";
	$.post(url,function(result){
		if(result.state==1){
			console.log(JSON.stringify(result.data));
			zTree = $.fn.zTree.init($("#typeTree"),//显示树的位置
								setting,      //树的基本配置
								result.data); //树上要显示的数据
			$("#typeLayer").css("display","block");
		}else{
			alert(result.message);
		}
	})
}
/**保存zTree选择数据,隐藏Ztree*/
function saveParentTreen(){
	if($(this).hasClass("btn-confirm")){
		var notes = zTree.getSelectedNodes();
		var note = notes[0];
		$(".form-horizontal #parentID").val(note.id);
		$(".form-horizontal .text-parentType").val(note.name);
	}
	$("#typeLayer").css("display","none");
}
function saveOrUpdateProductType(){
	if($(this).hasClass("btn-warning")){
		findObjects();
		if($("#editTypeForm").data("id"))
			$("#editTypeForm").removeData("id");
		return;
	}
	var typeId = $("#editTypeForm").data("id");
	var url =typeId?"productType/updateObjects.do":"productType/doSaveFormEditData.do";
	if(typeId)$("#editTypeForm #typeID").val(typeId);
	var	param = getFormEditData();
		console.log(JSON.stringify(param));
		$.post(url,param,function(result){
			if(result.state==1){
				$("#editTypeForm").removeData("id");
				findObjects();
			}else{
				alert(result.message);
			}
		});
}
function getFormEditData(){
	var param = $("#editTypeForm").serialize();
	return param;
}