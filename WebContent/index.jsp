
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-2.1.0.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript" src="scripts/index.js"></script>
<script type="text/javascript">
	$(function(){
		var id = "${param.id}";
		var parent= "${param.parent}";
		var page= "${param.page}";
		getOnLoad(id,parent,page);
		//alert("${sessionScope.lastView[0].name}");
		
	});
</script>
<title>易买网</title>
</head>
<body>
	<%@ include file="index_top.jsp"%>
	<div id="main" class="wrap">
		<div class="lefter">
			<%@ include file="index_product_sort.jsp"%>
			<div class="spacer"></div>
			<div class="last-view">
				<h2>最近浏览</h2>
				<dl class="clearfix">
					
					<c:forEach items="${sessionScope.lastView}" var="item">
						<dt>
							<img style="width: 54px; height: 54px;" src="${item.pictureFile_name }" />
						</dt>
						<dd>
							<a href="product_view.jsp?id=${item.id }">${item.name }</a>
						</dd>
					</c:forEach>
				</dl>
			</div>
		</div>
		<div class="main">
			<div class="price-off">
				<h2>商品展示</h2>
				<ul class="product clearfix">
					<div id="showProduct"></div>
				</ul>

				<div class="pager">
					<ul class="clearfix" id="pageUl" >
						<li id = "startPage"><a>上一页</a></li>
						<li id = "endPage"><a>下一页</a></li>
					</ul>
				</div>

			</div>
	
			<div class="side">
				<%@ include file="index_news.jsp"%>
			</div>

			<div class="spacer clear"></div>
			<div class="hot">
				<h2>热卖推荐</h2>
				<ul class="product clearfix">

					<li>
						<dl>
							<dt>
								<a href="#" target="_self"><img src="images/product/0.jpg" /></a>
							</dt>
							<dd class="title">
								<a href="#" target="_self">商品名称</a>
							</dd>
							<dd class="price">￥12.34</dd>
						</dl>
					</li>

					<li>
						<dl>
							<dt>
								<a href="#" target="_self"><img src="images/product/0.jpg" /></a>
							</dt>
							<dd class="title">
								<a href="#" target="_self">商品名称</a>
							</dd>
							<dd class="price">￥12.34</dd>
						</dl>
					</li>

					<li>
						<dl>
							<dt>
								<a href="#" target="_self"><img src="images/product/0.jpg" /></a>
							</dt>
							<dd class="title">
								<a href="#" target="_self">商品名称</a>
							</dd>
							<dd class="price">￥12.34</dd>
						</dl>
					</li>

				</ul>
			</div>
		</div>

		<div class="clear"></div>
	</div>
	<div id="footer">	Copyright &copy; 2017 TeaR All Rights Reserved. 京ICP证1000001号</div>
</body>
</html>

