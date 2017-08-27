<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix= "c" %> 
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!-- 表单 -->
	<div class="container">
	   <!-- 页面导航 -->
	   <div class="page-header">
			<div class="page-title" style="padding-bottom: 5px">
				<h3>旅游管理系统</h3>
				<ol class="breadcrumb">
				  <li>产品管理</li>
				  <li>产品信息</li>
				  <li class="active">产品信息管理</li>
				</ol>
			</div>
		</div>
		<form id="upFormId" method="POST" enctype="multipart/form-data">
		    <!-- 查询表单 -->
			<div class="row page-search">
			 <div class="col-md-12">
				<ul class="list-unstyled list-inline">
       					<li><input type="text" name="title" class="form-control"placeholder="附件标题"></li>
						<li><input type="file" name="mfile" class="form-control"></li>
						<li class='O1'><button id="uploadBtnId" type="button" class="btn btn-primary btn-upload" >上传</button></li>
				</ul>
			  </div>
			</div>
			<!-- 列表显示内容 -->
			<div class="row col-md-12">
				<table class="table table-bordered" data-click-to-select="true">
					<thead>
						<tr>
						   <th>选择</th>
							<th>文件名</th>
							<th>文件类型</th>
							<th>文件路径</th>
							<th>创建时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody id="tbody">
					
					</tbody>
				</table>
			</div>
		</form>
	</div>
<script type="text/javascript" src="${basePath}/js/attachement/attachement_list.js"></script>
