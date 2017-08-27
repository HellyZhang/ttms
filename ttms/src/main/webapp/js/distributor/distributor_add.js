$('#modal-dialog').on('click','.ok',saveFormData);
$("#modal-dialog").on("hidden.bs.modal", function() {
    $(this).removeData("bs.modal");
    $(this).off('click','.ok');
});
//保存表单数据
function saveFormData(){
	if($('#distAddForm').validate()){
	 var data = getFormParameters();
	 var url ='save.do';
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
	var name = $('#nameId').val();
	var category=$('#categoryId').val();
	var phone=$('#phoneId').val();
	var email=$('#emailId').val();
	var address=$('#addressId').val();
	var valid = $('input[name="validId"]:checked').val();
	var note=$('#noteId').val();
	var data = {
			'name':name,
			'category':category,
			'phone':phone,
			'email':email,
			'address':address,
			'valid':valid,
			'note':note
	};
	
	return data;
}