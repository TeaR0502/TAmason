// JavaScript Document
$(function() {
	//
	$.ajax({
		url:"getCategory?action=getName",
		data:{"cid":$("#pretitle").html()},
		type:"post",
		dataType:"html",
		success:function(data){
			$("title").html("易买网  - "+data);
			if (data == "首页"){
				data = "全部"
			}
			$(".price-off>h2").html(data+"  - 商品展示");
		},
		error:function(){
			alert("请刷新页面!");
		}
	})
	//
	
});

