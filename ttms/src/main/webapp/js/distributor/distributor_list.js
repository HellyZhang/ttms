$(document).ready(function() {
  $("#queryFormId").on('click','.btn_add',doShowAddDialog);
  $("#queryFormId").on('click','.btn_search',doGetObjects);	
  $("#queryFormId").on('click','.btn_valid',doValidById);	
  $("#queryFormId").on('click','.btn_invalid',doValidById);
  $('#queryFormId').on('click','.doShowUpdateDialog',doShowUpdateDialog);
  doGetObjects();
});
//显示列表页面
function doGetObjects(){
   var params=getQueryParamValues();
   var currentPage=$('#pagination').data('curPage');
   console.log('currentPage='+currentPage);
   if(currentPage){params.pageCurrent = currentPage;}
   var url='findObjects.do';
   $.post(url,params,function(result){
	   if(result.state==1){
		  appendObjects(result.data.list);
		  setPagination(result.data.pageObject);
	   }else{
		  alert(result.message);
	   }	   
   });
}
/*获取查询参数*/
function getQueryParamValues(){
	var name = $('#searchNameId').val();
	var valid=$('#searchValidId option:selected') .val();//选中的值
	var params = {'name':name,'valid':valid,}
	return params;
}
//页面刷新
function appendObjects(list){
   $('tBody').empty();
   for(var i in list){
   var tr=$('<tr></tr');
   tr.data("id",list[i].id);
   var template='<td width="50px"><input name="checkedItem" value="[id]" class="checkbox" type="checkbox"></td>'+
                '<td>[name]</td>'+
                '<td>[phone]</td>'+
                '<td>[email]</td>'+
                '<td>[valid]</td>'+
                '<td><a class="btn btn-default btn-xs doShowUpdateDialog">修改</a></td>';
   template=template.replace('[id]',list[i].id)
               .replace('[name]',list[i].name)
               .replace('[phone]',list[i].phone)
               .replace('[email]',list[i].email)
               .replace('[valid]',list[i].valid?'启用':'禁用');      
   tr.append(template);
   $('tBody').append(tr);
   }
}
//显示添加页面的模态框
function doShowAddDialog(){
	var uri='addUI.do?t='+Math.random(1000);
	$('#modal-dialog .modal-body').load(uri,function(){
		$('#modal-dialog .modal-title').html('添加分销商');
		$('#modal-dialog').modal('show');
	})
}
/**显示更新页面*/
function doShowUpdateDialog(){
	$("#modal-dialog").data("updateId",$(this).parent().parent().data("id"));
	var uri='updateUI.do?t='+Math.random(1000);
	$('#modal-dialog .modal-body').load(uri,function(){
		$('#modal-dialog .modal-title').html('编辑分销商');
		$('#modal-dialog').modal('show');
	})
}
//禁用&启用
function doValidById(){
	var state;
	//判断点击的按钮
	if($(this).hasClass("btn_valid")){
		state=1;
	}else{
		state=0;
	}
	//获得选中的id
	var checkedIds=getCheckedIds();
	if(checkedIds==''){
		alert("至少选择一个");
		return;
	}
	//发送ajax请求修改状态
	var url='doValidById.do';
	var params={'checkedIds':checkedIds,'valid':state}
	$.post(url,params,function(result){
		if(result.state==1){
		  doGetObjects();
		}else{
		  alert(result.message);
		}
	})
}
//获得选中的id，然后拼接成字符串
function getCheckedIds(){
	var checkedIds ='';
	$('tBody input[name="checkedItem"]').each(function(){
		if($(this).is(':checked')){  //或者用prop('checked')
			if(checkedIds==''){
			   checkedIds += $(this).val();
			}else{
			   checkedIds += ','+$(this).val();
			}
		}
	})
	return checkedIds;
}
