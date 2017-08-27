$(function(){
	getObjects();
	$("#queryFormId").on("click",".btn-search",function(){
		$(".pagination").data("pageCurrent",1);
		getObjects();});
});
$("#queryFormId").on("click",".btn-invalid,.btn-valid",validById);
/**查找所有项目*/
function getObjects(){
	var currentPage = $(".pagination").data("pageCurrent");
	var param = getParamInfo();
	if(currentPage){
		param.pageCurrent=currentPage;
	}
	$.post("project/getObject.do",param,function(result){
			var list = result.data.List_Projects;
			showProjects(list);
			var pageObject = result.data.pageObject;
			showPagesInfo(pageObject);
			LimitPagesJump();
		}
	);
}
/**异步请求参数*/
function getParamInfo(){
	var name = $(".list-inline #searchNameId").val();
	var valid = $(".list-inline #searchValidId").val();
	var param ={"name":name,"valid":valid};
	return param;
}
/**填充项目表格*/
function showProjects(list){
	var td = "<td><input type='checkbox' id='checkdId' value=[id] /></td><td>[code]</td><td>[name]</td><td>[beginDate]</td><td>[endDate]</td><td>[valid]</td><td><input type='button' class='btn-update' value='修改'/></td>";
	var tbody = $("#table_tbody");
	tbody.empty();
	for(var i in list){
		var tr =$("<tr></tr>");
		tr.append(td.replace('[id]',list[i].id).replace("[code]",list[i].code).replace("[name]",list[i].name).replace("[beginDate]",list[i].beginDate).replace("[endDate]",list[i].endDate).replace("[valid]",list[i].valid==1?"启用":"禁用"));
		tbody.append(tr);
	}
}
/**启用/禁用项目*/
function validById(){
	if($(this).hasClass("btn-invalid")){
		$("#queryFormId").data("valid",0);
	}else if($(this).hasClass("btn-valid")){
		$("#queryFormId").data("valid",1);
	}
	var param = getValidId();
	console.log("param:"+JSON.stringify(param));
	$.ajax({
		url:"project/validById.do",
		data:param,
		dataType:"json",
		success:function(result){
			if(result.state==1){
				getObjects();
			}else{
				alert(result.message);
			}
		},
		traditional:true
	});
}
function getValidId(){
	var arr = new Array();
	$("#queryFormId input[id='checkdId']").each(function(){
		if($(this).is(":checked")){
			arr.push($(this).val());
		}
	});
	var param = {"ids":arr,"valid":$("#queryFormId").data("valid")};
	return param;
}

