$(".list-inline").on("click",".btn-add",findAllProName);
$("#myModal").on("click",".btn-save",insertObjects);
$('#myModal').on('hidden.bs.modal', function (e) {
	$("#queryFormId").off("click",".btn-add");
});
/**添加团*/
function insertObjects(){
	var param = getAddTeamsInfo();
	console.log("param:"+param);
	var url = "team/doAddTeams.do";
	$.post(url,param,function(result){
		console.log("result:"+result);
		if(result.state==1){
			$('#myModal').modal("hide");
			getObjects();
		}else{
			alert(result.message);
		}
	})
}
/**获取添加团参数*/
function getAddTeamsInfo(){
	var param = $("#editFormId").serialize();
	return param;
}
/**初始化添加模态框&显示模态框*/
function findAllProName(){
	$("#myModal .modal-body").load("team/showEidtForm.do");
	$.post("team/findAllProName.do",function(result){
		if(result.state==1){
			var list = result.data;
			var option = "<option class='proName' value=[id]>[name]</option>";
			$("#selectProjectEditId .proName").remove();
			for(var i in list){
				$("#selectProjectEditId").append(option.replace("[id]",list[i].ID).replace("[name]",list[i].NAME));
			}
		}else{
			alert(result.message);
		}
	});
	$("#myModal").modal('show');
}