// JavaScript Document

//获取商品信息
function getPorduct(id) {
	//
	$.ajax({
		url : "getProduct?action=getProductById",
		data : {
			"id" : id
		},
		type : "post",
		dataType : "json",
		success : function(data) {
			var temp = "";
			if (data == null || data.length == 0) {
			} else {
				$(".thumb").html("<img style='width: 100px; height: 100px;' src='"+data.pictureFile_name+"' />");
				$("#product h1").html(data.name);
				$(".price").html(data.price);
				$("#stock").html(data.stock);
				$("#textname").html(data.name);
				$("#textdesc").html(data.description);
				$("#textprice").html(data.price);
				$("#textstock").html(data.stock);
				getPorductCategoryName(data.parent_id,"product-list");
				getPorductCategoryName(data.child_id,"productChild-list");
				
			}
		},
		error : function() {
			alert("请刷新页面!");
		}
	});
	//
	
}


//获取商品分类名
function getPorductCategoryName(id,idlist) {
	//
	$.ajax({
		url : "getCategory?action=getName",
		data : {
			"id" : id
		},
		type : "post",
		dataType : "html",
		success : function(data) {
			$("#"+idlist).html("<a href='product-list.jsp?id="+id+"' >"+data+"</a>");
		},
		error : function() {
			// alert("请刷新页面!");
		}
	});
	//
}


