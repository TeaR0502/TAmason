<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<%@ include file="index_top.jsp"  %>
<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
		<div class="box">
			<h1>请先登录易买网</h1>
			<div class="msg">
				<p>需要先登录才能进行操作!！</p>
				<p>正在进入登录页面...</p>
				<script type="text/javascript">
					setTimeout("location.href='login.jsp'", 3000);
				</script>
			</div>
		</div>
	</div>
</div>
<div id="footer">
	Copyright &copy; 2016 TeaR All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
