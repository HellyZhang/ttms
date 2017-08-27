<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix= "c" %> 
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
<title>Insert title here</title>
<link rel="stylesheet" href="${basePath}/css/bootstrap.min.css" />
<script type="text/javascript" src="${basePath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${basePath}/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="${basePath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${basePath}/js/common/page.js"></script>
<script type="text/javascript" src="${basePath}/js/team/team_list.js"></script>
</head>
<body>
    <!-- 表单 -->
	<div class="container">
	   <!-- 页面导航 -->
	   <div class="page-header">
			<div class="page-title" style="padding-bottom: 5px">
				<h3>旅游管理系统</h3>
				<ol class="breadcrumb">
				  <li>产品管理</li>
				  <li>团管理</li>
				  <li class="active">团信息管理</li>
				</ol>
			</div>
			<div class="page-stats"></div>
		</div>
		<form method="post" id="queryFormId">
		    <!-- 查询表单 -->
			<div class="row page-search">
			 <div class="col-md-12">
				<ul class="list-unstyled list-inline">
					<li><input type="text" id="searchNameId" class="form-control"placeholder="团名称"></li>
					<li><select id="selectProjectId" class="form-control">
							<option value="">选择项目</option>
					</select></li>
					<li class='O1'><button type="button" class="btn btn-primary btn-search" >查询</button></li>
					<li class='O2'><button type="button" class="btn btn-primary btn-add">添加</button></li>
					<li class='O3'><button type="button" class="btn btn-primary btn-invalid">禁用</button></li>
					<li class='O4'><button type="button" class="btn btn-primary btn-valid">启用</button></li>
				</ul>
			  </div>
			</div>
			<!-- 列表显示内容 -->
			<div class="row col-md-12">
				<table class="table table-bordered">
					<thead>
						<tr>
						    <th>选择</th>
							<th>团名称</th>
							<th>项目名称</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody></tbody>
				</table>
				<%@include file="../common/page.jsp" %>
			</div>
		</form>
	</div>
	<!-- modal dialog -->
	<div class="modal fade" id="modal-dialog" tabindex="-1" role="dialog" aria-labelledby="modalTitleLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="modalTitleLabel">New message</h4>
				</div>
				<div class="modal-body"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default cancel" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary ok">保存</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>