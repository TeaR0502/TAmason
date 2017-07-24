// JavaScript Document

function getOnLoad(id, parent, page) {
	
	//获取新闻列表
	//
	$.ajax({
		url : "newsServlet?action=getAll",
		data : {
		},
		type : "post",
		dataType : "json",
		success : function(data) {
			if (data == ""){
				alert("获取失败,请刷新重试");
			} else {
				temp ="";
				for (var i = 0; i < data.length; i++){
					temp += "<li><a href='news_view.jsp?id="+data[i].id+"'>"+data[i].title+"</a></li>"
				}
				/*
				<li>
				<a href="#">新闻标题</a>
				</li>
				*/
				$("#newsul").html(temp);
			}
		},
		error : function() {
			// alert("请刷新页面!");
		}
	});
	//
	
	
	
	//下一页按钮
	$("#endPage").click(function() {
		if (page == ""){
			page= parseInt("1");
		}
		if (page < count){
			page = parseInt(page)+1;
			getProduct(id, parent, page);
		}
	});
	//上一页按钮
	$("#startPage").click(function() {
		if (page != "" && page != 1){
			page = parseInt(page)-1;
			getProduct(id, parent, page);
		}
	});
	// 获取页面中商品信息
	getProduct(id, parent, page);

	// 获取对应分类名
	//
	$.ajax({
		url : "getCategory?action=getName",
		data : {
			"id" : id
		},
		type : "post",
		dataType : "html",
		success : function(data) {
			$("title").html("易买网  - " + data);
			if (data == "首页") {
				data = "全部"
			}
			$(".price-off>h2").html(data + "  - 商品展示");
		},
		error : function() {
			// alert("请刷新页面!");
		}
	});
	//
	
	//获取商品数量
	var count = 0;
	//
	$.ajax({
		url : "getCategory?action=getNumber",
		data : {
			"parent":parent,
			"id" : id
		},
		type : "post",
		dataType : "html",
		success : function(data) {
			count = Math.round(parseInt(data)/12);
		},
		error : function() {
			// alert("请刷新页面!");
		}
	});
	//
}


//获取商品信息并显示
function getProduct(id, parent, page) {
	$.ajax({
		url : "getProduct?action=getProductList",
		data : {
			"id" : id,
			"parent" : parent,
			"page" : page
		},
		type : "post",
		dataType : "json",
		success : function(data) {
			var temp = "";
			if (data == null || data.length == 0) {
				temp += "<li><h1>&nbsp;&nbsp;该分类<br>暂无商品!</h1></li>";
			} else {
				for (var i = 0; i < data.length; i++) {
					temp += "<li>" + "<dl>" + "<dt>"
							+ "<a href='product_view.jsp?id="+data[i].id+"' target='_self'><img src='"
							+ data[i].pictureFile_name + "' /></a>" + "</dt>"
							+ "<dd class='title'>"
							+ "<a href='product_view.jsp?id="+data[i].id+"' target='_self'>名称:" + data[i].name
							+ "</a>" + "</dd>" + "<dd class='price'> 价格:￥&nbsp;"
							+ data[i].price + "</dd>" + "</dl>" + "</li>";
				}
			}

			$("#showProduct").html(temp);
			

		},
		error : function() {
			alert("请刷新页面!");
		}
	});
	//
}
