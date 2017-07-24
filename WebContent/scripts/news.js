// JavaScript Document
function getLoad(id) {
	
	
	//获取完整的新闻信息
	//
	$.ajax({
		url : "newsServlet?action=getNew",
		data : {
			"id":id
		},
		type : "post",
		dataType : "json",
		success : function(data) {
			if (data == ""){
				alert("获取失败,请刷新重试");
			} else {
				//alert(data);
				//转换时间格式
				var newDate = new Date();
				newDate.setTime(data.create_time);
				
				
				$("#news>h1").html(data.title);
				$("#news").find("p").html(newDate.toLocaleString());
				
				$("#news").find("div").html($("#news").find("div").html()+"<br>"+data.content);
			}
		},
		error : function() {
			// alert("请刷新页面!");
		}
	});
	//
	
	
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
	
	
}

