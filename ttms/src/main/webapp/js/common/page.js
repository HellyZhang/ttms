$(function(){
	$(".pagination").on("click",".firstPage,.upperPage,.nextPage,.lastPage,.jump",PagesChange);
	LimitPagesJump();
});
/**填充页面信息*/
function showPagesInfo(pageObject){
	var pageCurrent = pageObject.pageCurrent;
	var pagesCount = pageObject.pagesCount;
	var rowCount = pageObject.rowCount;
	var ds = $(".pagination  #currentPage").text();
	$(".pagination #currentPage").text(pageCurrent+"/"+pagesCount);
	$(".pagination #totalCount").text(rowCount);
	$(".pagination").data("pageCurrent",pageCurrent);
	$(".pagination").data("pagesCount",pagesCount);
}
/**翻页*/
function PagesChange(){
	var attr = $(this).attr("class");
	var pagesCount = $(".pagination").data("pagesCount");
	var pageCurrent = $(".pagination").data("pageCurrent");
	if(attr=="firstPage"){
		$(".pagination").data("pageCurrent",1);
	}
	if(attr=="upperPage"){
		if(pageCurrent>1)
		$(".pagination").data("pageCurrent",pageCurrent-1);
	}
	if(attr=="nextPage"){
		
		if(pageCurrent<pagesCount)
		$(".pagination").data("pageCurrent",pageCurrent+1);
	}
	if(attr=="lastPage"){
		$(".pagination").data("pageCurrent",pagesCount);
	}
	if(attr=="jump"){
		var pageSelect = $("#pageSelect").val();
		$(".pagination").data("pageCurrent",pageSelect);
	}
	$(".pagination .form-control").val($(".pagination").data("pageCurrent"));
	getObjects();
}
/**跳转框页面跳转约束*/
function LimitPagesJump(){
	$(".pagination .form-control").attr("max", $(".pagination").data("pagesCount"));
	$(".pagination .form-control").attr("min", 1);
}
