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
<script type="text/javascript" src="${basePath}/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${basePath}/jquery/jquery.validate.min.js"></script>
<script type="text/javascript" src="${basePath}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${basePath}/bootstrap/js/bootstrap-datepicker.min.js"></script>
</head>
<body>
  <%@ include file="menu.jsp" %>
  <div id="container">
  	<p>helloword</p>
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
					<button type="button" class="btn btn-primary ok ">保存</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  	<div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
       
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
</body>
</html>