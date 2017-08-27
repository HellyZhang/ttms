$(document).ready(function(){
	$("#formHead").on("click",".btn-attachment",loadForm);
});
function loadForm(){
	var url = "attachement/loadUI.do";
	$("#container").load(url);
}