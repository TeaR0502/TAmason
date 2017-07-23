<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 物品详情</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-2.1.0.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript" src="scripts/product-view.js"></script>
<script type="text/javascript">
	$(function() {
		$("#addResultSuccess").hide(0);
		var id = "${param.id}";
		var uid = "${sessionScope.username}";
		//alert(uid);
		getPorduct(id);
		
		$("#addCart").click(function() {
			if (uid == ""){
				setTimeout("location.href='login.jsp'", 2000);
				alert("您还未登录!");
			} if (id == ""){
				alert(id);
				alert("参数异常!!");
			} else{
				//AJAX添加购物车
				//alert(uid);
					//
					$.ajax({
						url : "addCartServlet",
						data : {
							"id" : id,
							"username":uid
						},
						type : "post",
						dataType : "html",
						success : function(data) {
							if (data == 1 ) {
								$("#addResultSuccess").html("购物车添加成功!");
								$("#addResultSuccess").show(5000);
								
								setTimeout($("#addResultSuccess").hide(5000), 5000);
							} else {
								alert("购物车添加失败!请重试");
							}
						},
						error : function() {
							alert("请刷新页面!");
						}
					});
					//
			}
			
		});
	});
</script>
</head>
<body>
	<%@ include file="index_top.jsp"%>
	<div id="position" class="wrap">
		您现在的位置：<a href="index.jsp">易买网</a> &gt; <span id="product-list"></span>
		&gt; <span id="productChild-list"></span>
	</div>
	<div id="main" class="wrap">
		<div class="lefter">
			<%@ include file="index_product_sort.jsp"%>
		</div>
		<div id="product" class="main">
			<h1>找不到商品!</h1>
			<div class="infos">
				<div class="thumb">
					<img style="width: 100px; height: 100px;"
						src="images/product/0.jpg" />
				</div>
				<div class="buy">
					<p>
						商城价：<span class="price">￥9999.99</span>
					</p>
					<p>
						库 存：<span class="shadow" id="stock">无货</span>
					</p>
					<div class="button">
						<input type="button" id="addCart" value="" onclick="addCart()" />
						
					</div>
					<div class="search " >
						<h2 id="addResultSuccess"></h2>
					</div>
				</div>

				<div class="clear"></div>
			</div>
			<div class="introduce">
				<h2>
					<strong>商品详情</strong>
				</h2>
				<div class="text">
					商品名字：<span class="shadow" id="textname">找不到此商品</span><br /> 商品描述：<span
						class="shadow" id="textdesc">找不到此商品</span><br /> 商品价格：<span
						class="price" id="textprice">9999.99</span><br /> 商品库存：<span
						class="shadow" id="textstock">无货</span><br />
				</div>
			</div>
		</div>
		

		<div class="clear"></div>

	</div>
	<div id="footer">Copyright &copy; 2017 TeaR All Rights Reserved</div>
</body>
</html>

