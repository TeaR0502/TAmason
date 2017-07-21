
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="scripts/index-top.js"></script>
<div id="header" class="wrap">
	<div id="logo">
		<img src="images/logo.gif" />
	</div>

	<div class="help">
		<c:if test="${sessionScope.username == null }">
			<a href="login.jsp">登录</a>
			<a href="register.jsp">注册</a>
			<a href="#">留言</a>
		</c:if>
		<c:if test="${sessionScope.username != null }">
			<div id="myStyle">
				<li>欢迎用户 <span class="UserStyle">
						${sessionScope.username} </span>回到易购商城!
					<ul id="myStyleli">
						<li><a href="#" class="shopping">购物车</a> <a href="#">留言</a> <a
							href="exitServlet">退出</a></li>
					</ul>
				</li>
			</div>

		</c:if>

	</div>

	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">首页</a></li>

			<c:if test="${sessionScope.firstCategory == null }">
				<script type="text/javascript">
					$(function() {
						window.location.href = 'getCategory?action=get0'
					});
				</script>
			</c:if>

			<c:forEach items="${sessionScope.firstCategory}" var="category">
				<li><a href="index.jsp?id=${category.getId()}&parent=true">${category.getName()}</a></li>
			</c:forEach>
		</ul>
	</div>



</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">

			<li class="first"><a href="#">商品名称</a></li>

		</ul>
	</div>
	<!-- JiaThis Button BEGIN -->
	<script type="text/javascript"
		src="http://v2.jiathis.com/code/jiathis_r.js?move=0" charset="utf-8"></script>
	<!-- JiaThis Button END -->
</div>
