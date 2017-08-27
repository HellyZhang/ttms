$(function(){
	getObjects();
	$(".list-inline").on("click",".btn-search",getObjects);
});
function getObjects(){
	var param = getParamInfo();
	var pagecurrent = $(".pagination").data("pageCurrent");
	if(pagecurrent)param.pageCurrent=pagecurrent;
	$.post("team/findObjects.do",param,function(result){
		var list = result.data.list;
		doShowTeamsInf(list);
		var pageObject = result.data.pageObject;
		showPagesInfo(pageObject);
	});
}
/**显示主页团表*/
function doShowTeamsInf(list){
	var temp = "<td><input type='checkbox' name='check'/></td><td>[name]</td><td>[pname]</td><td>[valid]</td><td><input type='button' value='修改'/></td>"
	var tbody = $(".table-bordered .tbody");
	tbody.empty();
	for(var i in list){
		var tr = $("<tr></tr>");
		tr.append(temp.replace('[name]',list[i].name).replace('[pname]',list[i].ProName).replace('[valid]',list[i].valid?"有效":"无效"));
		tbody.append(tr);
	}
}
/**获取当前页/查询信息的参数*/
function getParamInfo(){
	var name = $(".list-inline #searchNameId").val();
	var valid = $(".list-inline #searchValidId").val();
	var param ={"name":name,"valid":valid};
	return param;
}