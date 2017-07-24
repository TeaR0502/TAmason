<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 新闻</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-2.1.0.js"></script>
<script type="text/javascript" src="scripts/news.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript">
	$(function() {
		var id = ${param.id};
		getLoad(id);
		
	});
</script>
</head>
<body>
<%@ include file="index_top.jsp"  %>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 阅读新闻
</div>
<div id="main" class="wrap">
	<div class="left-side">
		<%@ include file="index_news.jsp" %>
	</div>
	<div id="news" class="right-main">
		<h1>新闻标题</h1>
		<div class="content">
			<p style="text-align: right;">创建时间</p>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2016 上海海文 All Rights Reserved.
</div>
</body>
</html>

