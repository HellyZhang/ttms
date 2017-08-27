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
<title>旅游管理系统</title>
<link rel="stylesheet" href="${basePath}/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="${basePath}/bootstrap/css/bootstrap-datepicker.min.css" />
<link rel="stylesheet" href="${basePath}/static/css/font-awesome.min.css">
<link rel="stylesheet" href="${basePath}/static/plugins/ztree/css/metroStyle/metroStyle.css">
<link rel="stylesheet" href="${basePath}/bootstrap/css/bootstrap-table.min.css">
<link rel="stylesheet" href="${basePath}/static/css/main.css">
<link rel="stylesheet" href="${basePath}/static/plugins/treegrid/jquery.treegrid.css">

<script src="${basePath}/jquery/jquery-3.2.1.min.js"></script>
<script src="${basePath}/jquery/jquery.validate.min.js"></script>
<script src="${basePath}/jquery/jquery.form.js"></script>
<script src="${basePath}/bootstrap/js/bootstrap.min.js"></script>
<script src="${basePath}/bootstrap/js/bootstrap-datepicker.min.js"></script>
<script src="${basePath}/bootstrap/js/bootstrap-table.min.js"></script>
<script src="${basePath}/static/plugins/layer/layer.js"></script>
<script src="${basePath}/static/plugins/treegrid/jquery.treegrid.min.js"></script>
<script src="${basePath}/static/plugins/treegrid/jquery.treegrid.bootstrap3.js"></script>
<script src="${basePath}/static/plugins/treegrid/jquery.treegrid.extension.js"></script>
<script src="${basePath}/static/plugins/treegrid/tree.table.js"></script>
<script src="${basePath}/static/plugins/ztree/jquery.ztree.all.min.js"></script>
</head>
<body>
  <%@ include file="menu.jsp" %>
  <div id="container">
  </div>
  <!-- modal dialog -->
  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="modalTitleLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="modalTitleLabel">New message</h4>
				</div>
				<div class="modal-body">
				
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default cancel" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary btn-save">保存</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>