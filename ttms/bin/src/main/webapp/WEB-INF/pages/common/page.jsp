<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="pull-right" id="pagination">
	<ul class="pagination">
		<!-- 当前页/共多少页 -->
		<li
			style="padding: 6px 12px; border: 1px solid transparent; float: left">
			<strong id="currentPage">1/8</strong>页
		</li>
		<!-- 总记录数 -->
		<li
			style="padding: 6px 12px 6px 0px; border: 1px solid transparent; float: left">
			<strong id="totalCount">8</strong>条记录
		</li>
		<!-- 生成首页，上一页，下一页，尾页 -->
		<li><a class="firstPage">首页</a></li>
		<li><a title="上一页" class="upperPage">&laquo;</a></li>
		<li><a title="下一页" class="nextPage">&raquo;</a></li>
		<li><a class="lastPage">尾页</a></li>
		<!-- 生成跳转页面文本框 -->
		<li><a style="padding: 0px"> 
		<input type="number" id="pageSelect" name="pageSelect" class="form-control" value="1"
				style='width: 60px; margin: 0px; border: none; height: 30px' max="2" />
		</a></li>
		<li><a class="jump">跳转</a></li>
	</ul>
</nav>
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  	<div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">添加项目</h4>
      </div>
      <div class="modal-body">
       	<%@include file="../project/project_edit.jsp" %>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-cancle" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-save">保存</button>
      </div>
    </div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->