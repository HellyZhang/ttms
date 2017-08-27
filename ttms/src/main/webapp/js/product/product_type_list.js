
var columns =[{
		field : 'selectItem',
		radio : true
	},
	{
		title : '分类id',
		field : 'id',
		visible : false,
		align : 'center',
		valign : 'middle',
		width : '80px'
	},
	{
		title : '分类名称',
		field : 'name',
		align : 'center',
		valign : 'middle',
		sortable : true,
		width : '180px'
	},
	{
		title : '上级分类',
		field : 'parentName',
		align : 'center',
		valign : 'middle',
		sortable : true,
		width : '180px'
	},
	{
		title : '排序号',
		field : 'sort',
		align : 'center',
		valign : 'middle',
		sortable : true,
		width : '100px'
}];

$(document).ready(function(){
	findObjects();
	$("#formHead").on("click",".btn-add,.btn-update",loadEditPage);
	$("#formHead").on("click",".btn-delete",deleteObject);

});
	/**删除*/
	function deleteObject(){
		var id = getChechedId();
		var param = {"id":id};
		var url = "productType/deleteById.do";
		$.post(url,param,function(result){
			if(result.state==1){
				findObjects();
			}else{
				alert(result.message);
			}
			
		});
	}
	/**加载编辑页面*/
	function loadEditPage(){
		
		if($(this).hasClass("btn-update")){
			var id = getChechedId();
			if(id==-1){
				return;
			}
			var param = {"id":id}; 
			var url = "productType/findObjectById.do";
			$.post(url,param,function(result){
				if(result.state==1){
					var map = result.data;
					$("#editTypeForm").data("id",id);
					/**填充修改页面*/
					dofillUpate(map);
				}else{
					alert(result.message);
				}
			});
		}
		$(".container").load("productType/typeEdit.do");
	}
	/**获取选中项的id*/
	function getChechedId(){
		var selections = $("#typeTable").bootstrapTreeTable("getSelections");
		if(selections.length<1){
			alert("请先选中");
			return -1;
		}
		return selections[0].id;
	}
	/**填充修改页面*/
	function dofillUpate(map){
		$("#editTypeForm #typeNameId").val(map.name);
		$("#editTypeForm #parentID").val(map.parentId)
		$("#editTypeForm #parentNameId").val(map.parentName);
		$("#editTypeForm #typeSortId").val(map.sort);
		$("#editTypeForm #typeNoteId").val(map.note);
	}
	function findObjects(){
		var url = "productType/findObjects.do";
		var tableId = "typeTable";
		var table = new TreeTable(tableId, url, columns);
		table.setCodeField("id");
		table.setIdField("id");
		table.setParentCodeField("parentId");
		table.setExpandColumn(2);
		table.setExpandAll(false);
		table.init();
	}
