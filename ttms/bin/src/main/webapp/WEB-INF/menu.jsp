<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="navbar navbar-inverse" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#example-navbar-collapse">
				<span class="sr-only">切换导航</span> <span class="icon-bar"></span> 
				<span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"><img src="images/logo.png"height="100%" /></a>
		</div>
		<div class="collapse navbar-collapse" id="example-navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a class="icon-bar" href="#">旅游管理系统</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">产品管理 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li role="separator" class="divider"></li>
						<li><a id="load-project-id">项目信息</a></li>
						<li role="separator" class="divider"></li>
						<li><a id="load-team-id">团信息</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">产品分类</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">产品信息</a></li>
					</ul></li>
				<li><a href="#">分销管理</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">系统管理 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li role="separator" class="divider"></li>
						<li><a id="load-org-id">组织管理</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">角色管理</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">权限管理</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">用户管理</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a>欢迎您,admin</a></li>
				<li><a href="#">安全退出</a></li>
			</ul>
		</div>
	</div>
</div>
<script type="text/javascript">
$('#load-project-id').click(function(){
	var url="project/listUI.do?t="+Math.random(1000);
	$("#container").load(url);
})
$('#load-team-id').click(function(){
	var url="team/listUI.do?t="+Math.random(1000);
	$("#container").load(url);
})
/* $('#load-org-id').click(function(){
	var url="org/listUI.do?t="+Math.random(1000);
	$('#modal-dialog').data('parentId','');
	$("#container").load(url);
}) */
</script>
