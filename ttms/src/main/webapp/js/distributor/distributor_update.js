$(document).ready(function(){
	$('#modal-dialog').on('click','.ok',updateFormData);
	$("#modal-dialog").on("hidden.bs.modal", function() {
	    $(this).removeData("bs.modal");
	    $(this).off('click','.ok');
	});
	 doGetObjectById();
});
function doGetObjectById() {
	var id = $('#modal-dialog').data("updateId");
	var params = {'id':id};
	var url ='findById.do';
	$.post(url, params, function(result) {
		if (result.state == 1) {
			fillUpdateForm(result.data)
		} else {
			alert(result.message);
		}
	})
}
//填充编辑页面表单
function fillUpdateForm(obj){	
	$('#nameId').val(obj.name);
	$('#phoneId').val(obj.phone);
	$('#emailId').val(obj.email);
	$('#addressId').val(obj.address);
	$('#categoryId option').each(function(){
		console.log("obj.category="+obj.category);
		if(obj.category==$(this).val()){
			$(this).prop('selected',true);
		}
	});
 	//备注
 	$('#noteId').html(obj.note);
}
//保存表单数据
function updateFormData(){
	if($('#distUpdateForm').validate()){
	 var data = getFormParameters();
	 var url ='update.do';
	 $.post(url,data,function(jsonResult){
		if(jsonResult.state==1){
		 $('#modal-dialog').modal('hide');
		 doGetObjects();
		}else{ alert(jsonResult.message);}
	 });
	}
}
//获取表单数据
function getFormParameters(){
	var id=$("#modal-dialog").data("updateId");
	var name = $('#nameId').val();
	var phone=$('#phoneId').val();
	var category=$('#categoryId').val();
	var email=$('#emailId').val();
	var address=$('#addressId').val();
	var note=$('#noteId').val();
	var data = {
			'id':id,
			'name':name,
			'phone':phone,
			'category':category,
			'email':email,
			'address':address,
			'note':note
	};
	return data;
}