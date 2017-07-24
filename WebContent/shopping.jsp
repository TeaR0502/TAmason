<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 购物车</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-2.1.0.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript" src="scripts/shopping.js"></script>
<script type="text/javascript">
	//alert("${sesionScope.CartMap == null }");
	//alert("data.length == 0");
	$(function() {
		var username = "${sessionScope.username}";
		//alert(username);
		getAllCart(username);
	});
</script>
</head>
<body>
<%@ include file="index_top.jsp"  %>

<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 购物车
</div>
<div class="wrap">
	<div id="shopping" >
		<form action="DoBuyServlet" method="post">
			<table id="rediv">
				
				
					
				

			</table>
			<h1 id= "reh1" align="center">还没有添加任何物品到购物车!</h1>
			<div class="button"><input type="submit" value="" /></div>
		</form>
	</div>
</div>
<div id="footer">
	Copyright &copy; 2017 TeaR All Rights Reserved.
</div>
</body>
</html>

