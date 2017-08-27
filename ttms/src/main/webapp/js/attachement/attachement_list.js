$(document).ready(function(){
	doGetObjects();
	$("#upFormId").on("click","#uploadBtnId",uploadFile);
	$(".table-bordered #tbody").on("click","#downLoad",downLoad);
});
function doGetObjects(){
	var url = "attachement/getObjects.do"
	$.post(url,function(result){
		if(result.state==1){
			showTables(result.data);
		}else{
			alert(result.message);
		}
	});
}
function showTables(atts){
	var tbody =$(".table-bordered #tbody");
	var temp = "<td><input type='radio' name='attachement' id='attacheId' val=[id] /></td><td>[fileName]</td><td>[athType]</td><td>[filePath]</td><td>[createdTime]</td><td><input type='button' id='downLoad' value='下载'/><input type='button' value='删除'/></td>"
	tbody.empty();
	for(var i in atts){
		var tr = $("<tr></tr>");
		tr.append(temp.replace('[id]',atts[i].id).replace('[fileName]',atts[i].fileName).replace('[athType]',atts[i].athType).replace('[filePath]',atts[i].filePath).replace('[createdTime]',atts[i].createdTime));
		console.log(atts[i].id);
		tbody.append(tr);
	}
}
function uploadFile(){
		$("#upFormId").ajaxSubmit({
			url:"attachement/upLoad.do",
			type:"post",
			data:{"athType":1,"belongId":1},
			dataType:"json",
			success:function(result){
				if(result.state==1){
					alert("submit ok");
				}else{
					alert(result.message);
				}
			}
		});
		doGetObjects();
}
function downLoad(){
	var url = "attachement/download.do";
	var id = 152;
	console.log(id);
	var param = {"id":id};
	document.location.href=url+"?id=152";
	//$.post(url,param,function(result){
		
	//})
}