// JavaScript Document
$(function() {
	var page = "";
	
	//下一页按钮
	$("#endPage").click(function() {
		if (page == ""){
			page = parseInt("1");
		}
		if (page < count){
			page = parseInt(page)+1;
			getComment(page);
		}
	});
	//上一页按钮
	$("#startPage").click(function() {
		if (page != "" && page != 1){
			page = parseInt(page)-1;
			getComment(page);
		}
	});
	
	

	//初始化时获取留言
	getComment(1);
	
	//获取留言数量
	var count = 0;
	//
	$.ajax({
		url : "commentServlet?action=getNumber",
		data : {
			
		},
		type : "post",
		dataType : "html",
		success : function(data) {
			count = Math.round(parseInt(data)/2);
		},
		error : function() {
			// alert("请刷新页面!");
		}
	});
	//
	
	
});

function getComment(page) {
	//获取所有的留言
	
	//
	$.ajax({
		url : "commentServlet?action=getAll",
		data : {
			"page":page
		},
		type : "post",
		dataType : "json",
		success : function(data) {
			if (data == ""){
				alert("获取失败,请刷新重试");
			} else {
				/*
				 *<li>
					<dl>
						<dt>标题：1</dt>
						<dd class="author">作者：2</span></dd>
						<dd>内容：3</dd>
					</dl>
				</li> 
				 * 
				 */
				/*var newDate = new Date();
				newDate.setTime(data[i].create_time);
				newDate.toLocaleString()
				*/
				temp ="";
				//alert(data);
				for (var i = 0; i < data.length; i++){
					var newDate = new Date();
					newDate.setTime(data[i].create_time);
					temp += "<li>"+"<dl>"
					+"<dt>标题："+data[i].reply+"</dt>"
					+"<dd class='author'>作者："+data[i].nick_name+"<span> 				 留言时间:"+newDate.toLocaleString()+"</span> </dd>"
					+"<dd>内容："+data[i].content+"</dd>"
					+"</dl>"+"</li>";
						
				}
				
				$("#showComment").html(temp);
			}
		},
		error : function() {
			// alert("请刷新页面!");
		}
	});
	//
}

