	/**添加项目-显示模态框*/
	$("#queryFormId").on("click",".btn-add,.btn-update",showModal);
	/**保存数据*/
	$("#myModal").on("click",".btn-save,.btn-cancle",addorUpdateProjects);
	/**模态框隐藏时解绑*/
	$("#myModel").on("hidden.bs.modal",function(){
		$(this).off("click",".btn-save").removeData("id");
	});

/**显示模态框*/
function showModal(){
	$("#myModal .modal-body").load("project/showEidtForm.do");
	$("#myModal").modal('show');
	var title = "";
	if($(this).attr("class")=="btn btn-primary btn-add"){
		title = "添加项目";
	}else if($(this).attr("class")=="btn-update"){
		title = "修改项目";
		var id = $(this).parent().parent().find("#checkdId").val();
		$("#myModal").data("id",id);
		var param = {"id":id};
		$.post("project/findProjectById.do",param,function(result){
			if(result.state==1){
				var list = result.data;
				console.log(JSON.stringify(list));
				$(".editform .form-code").val(list.code);
				$(".editform .form-name").val(list.name);
				$(".editform .form-beginDate").val(list.beginDate);
				$(".editform .form-endDate").val(list.endDate);
				var valid = list.valid;
				$(".editform input[name=valid]").each(function(){
					if($(this).val==valid){
						$(this).prop("checked",true);
					}
				});
				$(".editform .form-note").val(list.note);
			}else{
				alert(result.message);
			}
		});
	}
	$("#myModal #modalTitleLabel").text(title);
}
/**添加项目*/
function addorUpdateProjects(){
	if($(this).hasClass("btn-cancle")){
		$("#myModal").modal('hide');
		return;
	}
	if($("#editformId").valid()){
		var id = $("#myModal").data("id");
		var url =id?"project/updateProject.do":"project/addProject.do";
		if(id)	$(".editform .proId").val(id);
		var param = getProjectInfo();
		$.post(url,param,function(result){
				if(result.state==1){
					$("#myModal").modal('hide');
					getObjects();
				}else{
					alert(result.message);
				}
			});
		}
}
/**获取项目信息*/
function getProjectInfo(){
	var param = $("#myModal .editform").serialize();
	console.log(JSON.stringify(param));
	return param;
}